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
@Table(name = "hazard_vw", schema = "ccd_app")
public class Hazard {


    @Id
    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "preferred_name")
    @JsonProperty("preferredName")
    private String preferredName;

    @Column(name = "casrn")
    @JsonProperty("casrn")
    private String casrn;

    @JsonRawValue
    @Column(name = "eco")
    @JsonProperty("eco")
    private String eco;

    @JsonRawValue
    @Column(name = "human")
    @JsonProperty("human")
    private String human;
}
