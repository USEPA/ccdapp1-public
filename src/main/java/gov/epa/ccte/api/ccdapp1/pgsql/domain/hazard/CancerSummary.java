package gov.epa.ccte.api.ccdapp1.pgsql.domain.hazard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "cancer_summary_vw", schema = "ccd_app")
public class CancerSummary {

    @Id
    private Integer id;


    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "source")
    @JsonProperty("source")
    private String source;

    @Column(name = "exposure_route")
    @JsonProperty("exposureRoute")
    private String exposureRoute;

    @Column(name = "cancer_call")
    @JsonProperty("cancerCall")
    private String cancerCall;

    @Column(name = "source_url")
    @JsonProperty("sourceUrl")
    private String sourceUrl;
}
