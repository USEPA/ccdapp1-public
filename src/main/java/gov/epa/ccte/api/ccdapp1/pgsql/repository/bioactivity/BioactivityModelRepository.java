package gov.epa.ccte.api.ccdapp1.pgsql.repository.bioactivity;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.BioactivityModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Bioactivity", itemResourceRel = "BioactivityModel", path = "bioactivity-model")
public interface BioactivityModelRepository extends JpaRepository<BioactivityModel, String> {

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    Optional<Page<BioactivityModel>> findByDtxsid(String id, Pageable pageable);


    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends BioactivityModel> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(BioactivityModel bioactivityModel);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends BioactivityModel> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
