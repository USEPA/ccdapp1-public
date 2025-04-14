package gov.epa.ccte.api.ccdapp1.pgsql.repository.actor;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.actor.AssayData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "AssayData", itemResourceRel = "AssayData", path = "actor-assay-data")
public interface AssayDataRepository extends JpaRepository<AssayData,Integer> {

    @RestResource(path = "by-dtxsid-category-assay", rel = "find-by-dtxsid-category-assay", exported = true)
    List<AssayData> findByDtxsidAndCategoryIdAndAssayIdOrderByComponentId(String dtxsid, Integer categoryId, Integer assayId);
}
