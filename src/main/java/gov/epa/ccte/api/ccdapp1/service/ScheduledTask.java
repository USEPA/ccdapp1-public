package gov.epa.ccte.api.ccdapp1.service;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.comments.Comments;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.CommentsRepository;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@EnableScheduling
public class ScheduledTask {

    private final CommentsRepository commentsRepository;

    private final JiraService jiraService;


    public ScheduledTask(CommentsRepository commentsRepository, JiraService jiraService) {
        this.commentsRepository = commentsRepository;
        this.jiraService = jiraService;
    }

    @Scheduled(cron = "0 0/10 * * * ?")
    @SchedulerLock(name = "TaskScheduler_scheduledTask", lockAtLeastFor = "9m", lockAtMostFor = "11m")
    public void processNullJiraIds() {

        try {
            List<Comments> comments = commentsRepository.findByJiraIdIsNull();
            log.info("cron job started");

            if (comments != null && !comments.isEmpty()) {
                for (Comments comment : comments) {
                    // create issue in Jira
                    String jiraId = jiraService.createIssue(comment);

                    // updating the database record
                    log.debug("The generated jira id is {}", jiraId);
                    comment.setJiraId(jiraId);
                    commentsRepository.save(comment);
                }
            }
        } catch (Exception ex) {
            log.error("An error occurred during scheduled task execution", ex);
        }
    }

    @Scheduled(cron = "0 0/30 * * * *")
    public void fetchJiraIssuesAndUpdateComments() {
        try {

                jiraService.fetchAllJiraIssuesAndUpdateComments();
        } catch (Exception ex) {
            log.error("An error occurred during scheduled task execution", ex);
        }
    }
}
