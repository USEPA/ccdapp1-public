package gov.epa.ccte.api.ccdapp1.pgsql.domain.hazard;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "genetox_summary_vw", schema = "ccd_app")
public class GenetoxicitySummary {

    @Id
    private Integer id;

    @JsonProperty("ames")
    @Column(name = "ames")
    private String ames;

    @JsonProperty("dtxsid")
    @Column(name = "dtxsid")
    private String dtxsid;

    @JsonProperty("micronucleus")
    @Column(name = "micronucleus")
    private String micronucleus;

    @JsonProperty("reportsNeg")
    @Column(name = "reports_neg")
    private String reportsNeg;

    @JsonProperty("reportsOther")
    @Column(name = "reports_other")
    private String reportsOther;

    @JsonProperty("reportsPos")
    @Column(name = "reports_pos")
    private String reportsPos;

    @JsonProperty("genetoxCall")
    @Column(name = "genetox_call")
    private String genetoxCall;

    @Column(name = "rn")
    @JsonProperty("rn")
    private int rn;


}
