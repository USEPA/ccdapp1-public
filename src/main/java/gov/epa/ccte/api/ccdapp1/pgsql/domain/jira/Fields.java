package gov.epa.ccte.api.ccdapp1.pgsql.domain.jira;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Fields {

    private Status status;

    @JsonProperty("customfield_25006")
    private String publicFeedback;
}
