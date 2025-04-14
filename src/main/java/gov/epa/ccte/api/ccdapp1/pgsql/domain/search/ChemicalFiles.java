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
@Table(name = "chemical_details")
public class ChemicalFiles  extends ChemicalDetails {
    @Column(name = "mol_file")
    @JsonProperty("molFile")
    private String molFile;

    @Column(name = "mrv_file")
    @JsonProperty("mrvFile")
    private String mrvFile;

    @Column(name = "mol_image")
    @JsonProperty("molImage")
    private byte[] molImage;
}
