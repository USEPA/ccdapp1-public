package gov.epa.ccte.api.ccdapp1.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.comments.Comments;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.jira.Issue;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.jira.IssuesResponse;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.CommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class JiraService {

    private final String jiraUrl;
    private final String jiraToken;

    private final CommentsRepository commentsRepository;

    private WebClient webClient;

    private static final String STATUS_ABANDONED = "Abandon";
    private static final String STATUS_DONE = "Done";
    private static final String STATUS_INPROGESS = "In Progress";
    private static final String STATUS_WORKING= "Working";
    private static final String STATUS_TRAINING_TEAM = "Training Team";
    private static final String STATUS_RESOLVED = "Resolved";


    private static final int MAX_RESULTS = 50;


    public JiraService(@Value("${spring.jira.url}") String jiraUrl, @Value("${spring.jira.token}") String jiraToken, CommentsRepository commentsRepository) {
        this.jiraUrl = jiraUrl;
        this.jiraToken = jiraToken;
        this.commentsRepository = commentsRepository;
        this.webClient = createWebClient();
    }

    private WebClient createWebClient() {
        if (jiraToken == null || jiraToken.isEmpty()) {
            log.debug("Jira Token is null or empty");
        }
        return WebClient.builder().baseUrl(jiraUrl).defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jiraToken).build();
    }


    public Mono<String> getIssue(String issueKey) {

        if (webClient == null) {
            log.debug("Webclient is not initialized due to invalid url or token ");
            throw new IllegalStateException("Webclient is not initialized due to invalid url or token");
        }
        return webClient.get()
                .uri(issueKey)
                .retrieve()
                .bodyToMono(String.class);
    }

    public String createIssue(Comments comment) {

        try {
            HttpHeaders headers = createHeaders(jiraToken);
            headers.setContentType(MediaType.APPLICATION_JSON);
            String requestJson = createRequestJson(comment);

            HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.exchange(jiraUrl, HttpMethod.POST, entity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return parseJiraId(responseEntity.getBody());
            } else {
                log.error("Error creating issue in JIRA: HTTP status " + responseEntity.getStatusCode());
                return null;
            }

        } catch (HttpStatusCodeException e) {
            log.error("HTTP error when creating issue in JIRA", e);
            throw new RuntimeException("Could not create issue in JIRA", e);
        } catch (Exception e) {
            log.error("Unexpected error when creating issue in JIRA", e);
            throw new RuntimeException("Could not create issue in JIRA", e);
        }
    }

    HttpHeaders createHeaders(String jiraToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + jiraToken);
        return headers;
    }

    String createRequestJson(Comments comment) {


        String summary = comment.getDtxsid() + "_" + comment.getChemName();

        String description = "id:" + comment.getId() + "\\n" +
                "chem_name:" + comment.getChemName() + "\\n" +
                "email:" + comment.getEmail() + "\\n" +
                "DTXSID-URL:" + comment.getAnnotationLocationUrl() + "\\n" +
                "desc:" + escapeJson(comment.getComment()) + "\\n" +
                "full_url:" + comment.getFullUrl() + "\\n" +
                "annotation_text:" + escapeJson(comment.getAnnotationText());

        return "{\n" +
                "    \"fields\": {\n" +
                "       \"project\":{\n" +
                "          \"key\": \"CCDCOM\"\n" +
                "       },\n" +
                "       \"summary\": \"" + summary + "\",\n" +
                "       \"description\": \"" + description + "\",\n" +
                "       \"issuetype\": {\n" +
                "          \"name\": \"Task\"\n" +
                "       }\n" +
                "   }\n" +
                "}";
    }

    private String escapeJson(String text) {
        if (text == null) return "";
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                // Remove pilcrow (¶) and pipe (|) symbols
                .replace("¶", "")
                .replace("|", "");
    }


    String parseJiraId(String responseJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseJson);
            String issueKey = root.path("key").asText();

            log.debug("Issue Key: " + issueKey);

            return issueKey;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse issue key from Jira response", e);
        }
    }

    public void fetchAllJiraIssuesAndUpdateComments() {

        try {
            List<Issue> result = getAllIssues();
            log.info("size of issues:" + result.size());

            updateVisibilityBasedOnIssueStatus(result);

        } catch (Exception e) {
            log.error("An error occurred while processing Jira issues: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateVisibilityBasedOnIssueStatus(List<Issue> issues) {
        try {
            if (issues != null) {
                for (Issue issue : issues) {
                    String status = issue.getFields().getStatus().getName();
                    String feedback = issue.getFields().getPublicFeedback();

                    Comments comment = commentsRepository.findByJiraId(issue.getKey());
                    if (comment != null) {
                        //setting  feedback regardless of status
                        if (feedback != null){
                            comment.setFeedback(feedback);
                        }

                        // Update status
                        if (STATUS_DONE.equalsIgnoreCase(status)) {
                            comment.setStatus("Resolved");
                        } else {
                            comment.setStatus(status);
                        }

                        // update visible based on status
                        if (STATUS_ABANDONED.equalsIgnoreCase(status)) {
                            comment.setVisible(false);
                        } else if (STATUS_DONE.equalsIgnoreCase(status) || STATUS_INPROGESS.equalsIgnoreCase(status)
                                || STATUS_WORKING.equalsIgnoreCase(status) || STATUS_TRAINING_TEAM.equalsIgnoreCase(status) || STATUS_RESOLVED.equalsIgnoreCase(status)) {
                            comment.setVisible(true);
                        }
                        commentsRepository.save(comment);
                    }
                }
            }
        } catch (DataAccessException dae) {
            log.error("Database error occurred while updating comments visibility field: " + dae.getMessage());
        } catch (Exception e) {
            // To handle other generic exceptions
            log.error("An unexpected error occurred: " + e.getMessage());
        }
    }

    public List<Issue> getAllIssues() {
        List<Issue> allIssues = new ArrayList<>();
        int startAt = 0;

        while (true) {

            RestTemplate restTemplate = new RestTemplate();

            //Getting results from last two months
            LocalDate today = LocalDate.now();
            LocalDate oneMonthAgo = today.minusMonths(2);

            String jql = "created >= " + oneMonthAgo.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            headers.setBearerAuth(jiraToken);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            String url = jiraUrl.replace("/issue", "") + "/search?jql=" + jql + " AND PROJECT=CCDCOM&startAt=" + startAt + "&maxResults=" + MAX_RESULTS;

            ResponseEntity<IssuesResponse> result = restTemplate.exchange(url, HttpMethod.GET, entity, IssuesResponse.class);

            log.info("total number of issues " + result.getBody().getIssues().size());

            if (result.getBody().getIssues() != null && !result.getBody().getIssues().isEmpty()) {
                allIssues.addAll(result.getBody().getIssues());

                // If returned results are less than maxResults, break the loop
                if (result.getBody().getIssues().size() < MAX_RESULTS) {
                    break;
                }

                startAt += MAX_RESULTS;
            } else {
                break;
            }
        }

        return allIssues;
    }

}