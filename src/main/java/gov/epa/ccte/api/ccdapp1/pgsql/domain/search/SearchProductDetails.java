package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.ChemicalDetails;
import lombok.Data;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Data
@Immutable
@Table(name = "vw_product_search")
public class SearchProductDetails extends ChemicalDetails {

    @Column(name = "search_name")
    @JsonProperty("searchMatch")
    private String searchMatch;

    @Column(name = "search_value")
    @JsonProperty("searchWord")
    private String searchWord;

    @Column(name = "modified_value")
    @JsonProperty("modifiedValue")
    private String modifiedValue;

}
