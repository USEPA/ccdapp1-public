package gov.epa.ccte.api.ccdapp1.pgsql.repository.search;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchMassAndFormula;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchMsReadyFormula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface SearchMsReadyFormulaRepository extends JpaRepository<SearchMsReadyFormula, String> {

    @Query( value = "Select * from  {h-schema}chemical_details " +
            "where dtxsid in ( Select distinct r.dtxsid from {h-schema}search_ms_ready r where r.mol_formula= :formula )",
            nativeQuery = true)
    List<SearchMsReadyFormula>getMsReadyFormula(@Param("formula") String formula);

    @Query( value = "Select * from  {h-schema}chemical_details " +
            "where dtxsid in ( Select distinct r.dtxsid from {h-schema}search_ms_ready r where mol_formula in (:formulas) )",
            nativeQuery = true)
    List<SearchMsReadyFormula>getMsReadyFormula(@Param("formulas")  List<String> formulas);

    @Query(value = "SELECT * FROM {h-schema}chemical_details " +
            "WHERE mol_formula LIKE %:formula%",
            nativeQuery = true)
    List<SearchMsReadyFormula> getMsReadyFormulaContaining(@Param("formula") String formula);
}
