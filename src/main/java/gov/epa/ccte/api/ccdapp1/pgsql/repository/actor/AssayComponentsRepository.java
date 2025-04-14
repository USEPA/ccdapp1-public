package gov.epa.ccte.api.ccdapp1.pgsql.repository.actor;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.actor.AssayComponents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "AssayComponents", itemResourceRel = "AssayComponent", path = "actor-assay-components")
public interface AssayComponentsRepository extends JpaRepository<AssayComponents,Integer> {

//    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
//    List<AssayComponents> findByDtxsid(String dtxsid);

    @RestResource(path = "by-assayid", rel = "find-by-assayid", exported = true)
    List<AssayComponents> findByAssayId(Integer assayId);
}
