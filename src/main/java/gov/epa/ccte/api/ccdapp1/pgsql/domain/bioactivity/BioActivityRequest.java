package gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BioActivityRequest {


    @JsonProperty("dtxsid")
    private String dtxsid;


    @JsonProperty("representativeSample")
    private String representativeSample;

    @JsonProperty("asayComponentEndpointNames")
    private List<String> asayComponentEndpointNames;
}
