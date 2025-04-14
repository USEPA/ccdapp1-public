package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class ProductResult {

    @JsonProperty("searchValue")
    private String searchValue;

    @JsonProperty("searchName")
    private String searchName;

    @JsonProperty("searchValueDesc")
    private String searchValueDesc;
}
