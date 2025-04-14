package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "news", path = "news")
public interface NewsRepository extends CrudRepository<News, Integer> {

    @RestResource(path = "all-news", rel = "news", exported = true)
    List<News> findAllByOrderByUpdatedAtDesc();


    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends News> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends News> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(News news);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends News> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
