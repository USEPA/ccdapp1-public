package gov.epa.ccte.api.ccdapp1.pgsql.repository.links;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.links.Ids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ids", path = "links-ids")
public interface IdsRepository extends JpaRepository<Ids, Integer> {

    @Override
    @Hidden
    @RestResource(exported = false)
    List<Ids> findAll();

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Ids> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Ids ids);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Ids> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}



