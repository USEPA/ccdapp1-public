package gov.epa.ccte.api.ccdapp1.pgsql.repository.actor;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.actor.AssayCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "AssayCategories", itemResourceRel = "AssayCategory", path = "actor-categories")
public interface AssayCategoriesRepository extends JpaRepository<AssayCategories,Integer> {

//    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
//    @Query("from AssayCategories where dtxsid = ?1 and level=1")
//    List<AssayCategories> getCategories(String dtxsid);

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = true)
    @Query("from AssayCategories where dtxsid = ?1 and displayHeaderNumber =1 and isVisible = true order by categoryName")
    List<AssayCategories> findByDtxsid(String dtxsid);
}
