package gov.epa.ccte.api.ccdapp1.pgsql.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "analytical_qc")
public class AnalyticalQcData {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "link")
    @JsonProperty("link")
    private String link;

    @Column(name = "label_message")
    @JsonProperty("labelMessage")
    private String labelMessage;

    @Column(name = "enable_ind")
    @JsonProperty("enableIndicator")
    private boolean enableIndicator;
}
