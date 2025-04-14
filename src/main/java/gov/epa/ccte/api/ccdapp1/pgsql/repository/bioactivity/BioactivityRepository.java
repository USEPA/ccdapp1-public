package gov.epa.ccte.api.ccdapp1.pgsql.repository.bioactivity;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.Bioactivity;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.BioactivityAssayDetails;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.BioactivitySummaryTab;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Bioactivity", itemResourceRel = "Bioactivity", path = "bioactivity-data")
public interface BioactivityRepository extends JpaRepository<Bioactivity, Integer> {

    @RestResource(path = "by-one-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<Bioactivity> findByDtxsid(String id);

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    Optional<Page<Bioactivity>> findByDtxsidAndAssayComponentEndpNm(@Param("id") String dtxsid, @Param("assay") String assayName,  Pageable pageable);


    @RestResource(path = "by-dtxsid-with-rs", rel = "find-by-dtxsid-with-rs", exported = true)
    @Query("select b from Bioactivity b where b.mc5ChidRep = 1 and  b.dtxsid = :id and b.assayComponentEndpNm = :assay ")
    Optional<Page<Bioactivity>> findBySampleRep(@Param("id") String dtxsid, @Param("assay") String assayName, Pageable pageable);


    @Query("select b from Bioactivity b where b.mc5ChidRep = 1 and  b.dtxsid = :id and b.assayComponentEndpNm in :assays ")
    List<Bioactivity>   findByDtxsidAndAssayComponentEndpointNmIn(@Param("id")String dtxsid, @Param("assays")List<String> asayComponentEndpointNames);

    @Query("select b from Bioactivity b  where b.dtxsid = :id and b.assayComponentEndpNm in :assays ")
    List<Bioactivity>  findByDtxsidAndAssayComponentEndpointNameIn(@Param("id")String dtxsid, @Param("assays")List<String> asayComponentEndpointNames);

    // endpoints for EDSP

    @RestResource(path = "edsp-by-dtxsid", rel = "find-by-dtxsid", exported = true)
    @Query("from Bioactivity b where b.assayList like '%EDSP%' and b.dtxsid = :id and b.assayComponentEndpNm = :assay")
    Optional<Page<Bioactivity>> findEdspData(@Param("id") String dtxsid, @Param("assay") String assayName,  Pageable pageable);

    @RestResource(path = "edsp-by-dtxsid-with-rs", rel = "find-by-dtxsid", exported = true)
    @Query("from Bioactivity b where b.mc5ChidRep = 1 and b.assayList like '%EDSP%' and b.dtxsid = :id and b.assayComponentEndpNm = :assay")
    Optional<Page<Bioactivity>> findEdspDataWithRepSample(@Param("id") String dtxsid, @Param("assay") String assayName,  Pageable pageable);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Bioactivity> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Bioactivity bioactivity);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Bioactivity> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
