package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.ReleaseInfo;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ReleaseInfo", path = "release-info")
public interface ReleaseInfoRepository extends CrudRepository<ReleaseInfo, Integer> {
    

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends ReleaseInfo> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends ReleaseInfo> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(ReleaseInfo ReleaseInfo);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends ReleaseInfo> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
