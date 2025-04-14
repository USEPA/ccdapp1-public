package gov.epa.ccte.api.ccdapp1.pgsql.repository.bioactivity;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.BioactivitySummaryTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Bioactivity", itemResourceRel = "BioactivitySummary", path = "bioactivity-summary")
public interface BioactivitySummaryTabRepository  extends JpaRepository<BioactivitySummaryTab, Integer> {

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    List<BioactivitySummaryTab> findByDtxsid(String id);

    @Query("select count(b) from BioactivitySummaryTab b where b.hitCall = 1 and b.dtxsid =:id")
    @RestResource(path = "count-by-dtxsid", rel = "find-by-dtxsid", exported = true)
    Long countByDtxsid(@Param("id") String dtxsid);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends BioactivitySummaryTab> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(BioactivitySummaryTab bioactivitySummaryTab);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends BioactivitySummaryTab> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
