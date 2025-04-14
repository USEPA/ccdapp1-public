package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Data
@Table(name = "search_product")
public class SearchProduct {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "search_value")
    @JsonProperty("searchValue")
    private String searchValue;


    @Column(name = "modified_value")
    @JsonProperty("modifiedValue")
    private String modifiedValue;

    @Column(name = "search_name")
    @JsonProperty("searchName")
    private String searchName;

    @Column(name = "search_value_desc")
    @JsonProperty("searchValueDesc")
    private String searchValueDesc;

}
