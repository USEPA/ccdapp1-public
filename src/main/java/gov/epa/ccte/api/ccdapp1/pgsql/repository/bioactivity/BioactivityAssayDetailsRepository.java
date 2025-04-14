package gov.epa.ccte.api.ccdapp1.pgsql.repository.bioactivity;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.Bioactivity;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.BioactivityAssayDetails;
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
@RepositoryRestResource(collectionResourceRel = "Bioactivity", itemResourceRel = "Bioactivity", path = "bioactivity-assay-details")
public interface BioactivityAssayDetailsRepository extends JpaRepository<BioactivityAssayDetails, String> {

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    @Query("select b from BioactivityAssayDetails b where b.chidRep  = 1 and  b.dtxsid = :id")
    List<BioactivityAssayDetails> findByDtxsid(@Param("id") String dtxsid);

    @RestResource(path = "by-dtxsid-with-assay", rel = "find-by-dtxsid", exported = true)
    List<BioactivityAssayDetails> findByDtxsidAndNameIn(@Param("id") String dtxsid, @Param("assays") List<String> assays);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends BioactivityAssayDetails> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(BioactivityAssayDetails bioactivityAssayDetails);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends BioactivityAssayDetails> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
