package gov.epa.ccte.api.ccdapp1.web.rest;


import gov.epa.ccte.api.ccdapp1.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/jira")
public class JiraController {

    private final JiraService jiraService;

    @Autowired
    public JiraController(JiraService jiraService) {
        this.jiraService = jiraService;
    }

    @GetMapping("/issue/{issueKey}")
    public Mono<ResponseEntity<String>> getIssue(@PathVariable String issueKey) {
            return jiraService.getIssue(issueKey)
                    .map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());

    }
}
