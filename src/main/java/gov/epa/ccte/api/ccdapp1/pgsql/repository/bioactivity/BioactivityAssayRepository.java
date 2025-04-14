package gov.epa.ccte.api.ccdapp1.pgsql.repository.bioactivity;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.BioactivityAssay;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.BioactivityAssayDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Bioactivity", itemResourceRel = "Bioactivity", path = "bioactivity-assay")
public interface BioactivityAssayRepository extends JpaRepository<BioactivityAssay, String> {

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<BioactivityAssay> findByDtxsid(@Param("id") String dtxsid);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends BioactivityAssay> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(BioactivityAssay bioactivityAssay);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends BioactivityAssay> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
