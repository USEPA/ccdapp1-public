package gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.AbstractAuditingEntity;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "chemical_data_status")
public class ChemicalDataStatus extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "dtxcid")
    @JsonProperty("dtxcid")
    private String dtxcid;

    @Column(name = "label_key")
    @JsonProperty("label")
    private String label;

    @Column(name = "disable")
    @JsonProperty("disable")
    private Boolean disable;
}
