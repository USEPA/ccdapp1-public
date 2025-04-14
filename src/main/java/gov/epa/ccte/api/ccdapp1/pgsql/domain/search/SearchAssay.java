package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "search_assay")
public class SearchAssay {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "search_name")
    @JsonProperty("searchMatch")
    private String searchMatch;

    @Column(name = "search_value")
    @JsonProperty("searchWord")
    private String searchWord;

    @Column(name = "modified_value")
    @JsonProperty("modifiedValue")
    private String modifiedValue;

    @Column(name = "search_value_desc")
    @JsonProperty("searchValueDesc")
    private String searchValueDesc;
}
