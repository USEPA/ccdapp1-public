package gov.epa.ccte.api.ccdapp1.pgsql.repository.search;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchMsReady;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface SearchMsReadyRepository extends JpaRepository<SearchMsReady, String> {

    @Query(value = "select count(*) from (select distinct dtxsid" +
            "    from {h-schema}search_ms_ready" +
            "    where mol_formula = :formula and  dtxsid <> :dtxsidToAvoid ) ms ", nativeQuery = true)
    long countByMolFormulaIsAndDtxsidIsNot(String formula, String dtxsidToAvoid);
}