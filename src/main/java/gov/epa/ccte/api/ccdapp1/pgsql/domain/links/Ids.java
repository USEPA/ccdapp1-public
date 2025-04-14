package gov.epa.ccte.api.ccdapp1.pgsql.domain.links;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.AbstractAuditingEntity;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "chemical_link_data")
public class Ids extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "param_type")
    @JsonProperty("paramType")
    private String paramType;

    @Column(name = "param_value")
    @JsonProperty("paramValue")
    private String paramValue;

    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;


}
