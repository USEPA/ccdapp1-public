package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.HelpText;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "helptext", path = "helptext")
    public interface HelpTextRepository extends CrudRepository<HelpText, Integer> {


    @RestResource(path = "by-helptextid", rel = "find-by-helptextid", exported = true)
    Optional<HelpText> findByHelpTextId(@Param("id") String helpTextId);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends HelpText> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends HelpText> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(HelpText helpText);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends HelpText> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}

