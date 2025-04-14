package gov.epa.ccte.api.ccdapp1.pgsql.repository.actor;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.actor.Assays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Assays", itemResourceRel = "Assay", path = "actor-assays")
public interface AssaysRepository extends JpaRepository<Assays, Integer> {

    @RestResource(path = "by-dtxsid-categoryid", rel = "find-by-dtxsid-categoryid", exported = true)
    List<Assays> findByDtxsidAndCategoryId(String dtxsid, Integer categoryId);
}
