package gov.epa.ccte.api.ccdapp1.pgsql.repository.hazard;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.hazard.CancerSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CancerSummary", itemResourceRel = "CancerSummary", path = "cancer-summary")
public interface CancerSummaryRepository extends JpaRepository<CancerSummary, String> {


    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<CancerSummary> findByDtxsid(@Param("id") String dtxsid);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends CancerSummary> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(CancerSummary CancerSummary);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends CancerSummary> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
