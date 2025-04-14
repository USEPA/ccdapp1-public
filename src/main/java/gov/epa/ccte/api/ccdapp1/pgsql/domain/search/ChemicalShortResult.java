package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import java.math.BigInteger;

// @Entity
@Setter
@Getter
@RequiredArgsConstructor
public class ChemicalShortResult {

    @JsonProperty("dtxsid")
    final private String dtxsid;

    @JsonProperty("dtxcid")
    final private String dtxcid;

    @JsonProperty("searchMatch")
    final private String searchMatch;

    @JsonProperty("rank")
    final private Integer rank;

    @JsonProperty("hasStructureImage")
    final private Boolean hasStructureImage;

    @JsonProperty("searchWord")
    final private String searchWord;

}
