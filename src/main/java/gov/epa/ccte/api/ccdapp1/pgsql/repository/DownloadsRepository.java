package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.Downloads;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "downloads", path = "downloads")
public interface DownloadsRepository extends CrudRepository<Downloads, Integer> {

    @RestResource(path = "all-downloads", rel = "downloads", exported = true)
    List<Downloads> findAllByOrderByUpdatedAtDesc();

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Downloads> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Downloads> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Downloads downloads);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Downloads> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}