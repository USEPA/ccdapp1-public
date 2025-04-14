package gov.epa.ccte.api.ccdapp1.pgsql.domain.jira;

import lombok.Data;

@Data
public class Issue {

    private String key;

    private Fields fields;

}
