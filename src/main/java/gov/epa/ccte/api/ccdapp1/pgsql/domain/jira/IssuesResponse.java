package gov.epa.ccte.api.ccdapp1.pgsql.domain.jira;

import lombok.Data;

import java.util.List;

@Data
public class IssuesResponse {

    private List<Issue> issues;
}
