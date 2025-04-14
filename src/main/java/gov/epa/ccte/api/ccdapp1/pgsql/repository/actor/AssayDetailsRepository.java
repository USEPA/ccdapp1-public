package gov.epa.ccte.api.ccdapp1.pgsql.repository.actor;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.actor.AssayDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "AssayDetail", itemResourceRel = "AssayDetail", path = "actor-assay-detail")
public interface AssayDetailsRepository extends JpaRepository<AssayDetails, Integer> {

//    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
//    List<AssayDetails> findByDtxsid(String dtxsid);

    @RestResource(path = "by-assay-category", rel = "find-by-assay-category", exported = true)
    AssayDetails findByAssayIdAndCategoryId(Integer assayId, Integer categoryId);

}
