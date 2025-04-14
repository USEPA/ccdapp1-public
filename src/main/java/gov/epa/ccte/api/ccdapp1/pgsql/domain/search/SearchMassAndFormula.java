package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.ChemicalDetails;
import lombok.Data;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Data
@Immutable
@Table(name = "chemical_details")
public class SearchMassAndFormula extends ChemicalDetails {

    private Double massDiff;
    private String toxvalData;

}
