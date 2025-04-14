package gov.epa.ccte.api.ccdapp1.pgsql.repository.hazard;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.hazard.SkinEye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "SkinEye", itemResourceRel = "SkinEye", path = "skin-eye")
public interface SkinEyeRepository extends JpaRepository<SkinEye, String> {


    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<SkinEye> findByDtxsid(@Param("id") String dtxsid);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends SkinEye> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(SkinEye SkinEye);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends SkinEye> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
