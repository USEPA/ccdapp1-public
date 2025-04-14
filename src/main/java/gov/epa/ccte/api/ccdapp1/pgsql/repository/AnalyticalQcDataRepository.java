package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.AnalyticalQcData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "AnalyticalQcData", itemResourceRel = "AnalyticalQcData", path = "analytical-qc-data")
public interface AnalyticalQcDataRepository extends JpaRepository<AnalyticalQcData, Integer> {

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<AnalyticalQcData> findByDtxsid(String id);

    @Override
    List<AnalyticalQcData> findAll();

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends AnalyticalQcData> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(AnalyticalQcData analyticalQcData);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends AnalyticalQcData> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
