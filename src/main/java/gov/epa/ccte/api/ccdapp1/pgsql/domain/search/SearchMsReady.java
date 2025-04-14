package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;


@Entity
@Data
@Immutable
@Table(name = "search_ms_ready")
public class SearchMsReady {


    @Id
    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "dtxcid")
    @JsonProperty("dtxcid")
    private String dtxcid;

    @Column(name = "mol_formula")
    @JsonProperty("molFormula")
    private String molFormula;

}
