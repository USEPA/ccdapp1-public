package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "feedback", path = "feedback")
public interface FeedbackRepository  extends JpaRepository<Feedback, Integer> {

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Feedback feedback);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Feedback> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
