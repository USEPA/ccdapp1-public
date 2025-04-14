package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "chemlist_to_subtance")
public class ChemicalListToSubstance {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "list_name")
    @JsonProperty("listName")
    private String listName;

}
