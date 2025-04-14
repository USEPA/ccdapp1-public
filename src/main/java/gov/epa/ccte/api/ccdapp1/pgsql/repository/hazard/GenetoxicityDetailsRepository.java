package gov.epa.ccte.api.ccdapp1.pgsql.repository.hazard;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.hazard.GenetoxicityDetails;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "GenetoxicityDetails", itemResourceRel = "GenetoxicityDetails", path = "genetoxicity-details")
public interface GenetoxicityDetailsRepository extends JpaRepository<GenetoxicityDetails, String> {


    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<GenetoxicityDetails> findByDtxsid(@Param("id") String dtxsid);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends GenetoxicityDetails> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(GenetoxicityDetails GenetoxicityDetails);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends GenetoxicityDetails> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
