package gov.epa.ccte.api.ccdapp1.pgsql.repository.hazard;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.hazard.Hazard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Hazard", itemResourceRel = "Hazard", path = "hazard")
public interface HazardRepository extends JpaRepository<Hazard, String> {


    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<Hazard> findByDtxsid(@Param("id") String dtxsid);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Hazard> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Hazard hazard);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Hazard> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
