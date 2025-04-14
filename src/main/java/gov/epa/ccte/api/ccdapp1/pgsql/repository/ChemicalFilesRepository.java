package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ChemicalFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import io.swagger.v3.oas.annotations.Hidden;

@RepositoryRestResource(exported = false)
public interface ChemicalFilesRepository extends JpaRepository<ChemicalFiles, String> {

/*    <T> Optional<T> findByDtxsid(String dtxsid, Class<T> type);

    <T> Optional<T> findByDtxcid(String dtxcid, Class<T> type);*/

    ChemicalFiles findByDtxsid(String dtxsid);

    @Query(value = "select c.molImage from ChemicalFiles c where c.dtxsid = :dtxsid")
    byte[] getMolImageForDtxsid(@Param("dtxsid") String dtxsid);

    @Query(value = "select c.molImage from ChemicalFiles c where c.dtxcid = :dtxcid")
    byte[] getMolImageForDtxcid(@Param("dtxcid") String dtxcid);

    @Query(value = "select c.molFile from ChemicalFiles c where c.dtxsid = :dtxsid")
    String getMolFileForDtxsid(@Param("dtxsid") String dtxsid);

    @Query(value = "select c.molFile from ChemicalFiles c where c.dtxcid = :dtxcid")
    String getMolFileForDtxcid(@Param("dtxcid") String dtxcid);


    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends ChemicalFiles> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(ChemicalFiles chemicalFiles);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends ChemicalFiles> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
/*
    @RestResource(exported = false)
    <T> List<T> findTop20BySearchMatchInAndModifiedValueStartsWithOrderByRankAscSearchWordAsc(List<String> searchMatchToInclude, String searchWord, Class<T> type);
*/

}
