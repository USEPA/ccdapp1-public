package gov.epa.ccte.api.ccdapp1.pgsql.repository.bioactivity;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.Bioactivity;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.Cytotox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Bioactivity", itemResourceRel = "Bioactivity", path = "bioactivity-cytotox")
public interface CytotoxRepository extends JpaRepository<Cytotox, String> {

    /*
    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    Optional<Page<Bioactivity>> findByDtxsidAndAssayComponentEndpNm(@Param("id") String dtxsid, @Param("assay") String assayName, Pageable pageable);
    */

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<Cytotox> findByDtxsid(@Param("id") String dtxsid);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Cytotox> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Cytotox cytotox);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Cytotox> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
