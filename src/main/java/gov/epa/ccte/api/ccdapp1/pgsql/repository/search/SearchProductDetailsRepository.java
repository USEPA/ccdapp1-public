package gov.epa.ccte.api.ccdapp1.pgsql.repository.search;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface SearchProductDetailsRepository extends JpaRepository<SearchProductDetails, String> {

    @RestResource(exported = false)
    List<SearchProductDetails> findByModifiedValueEqualsOrderByDtxsid(String searchWord);
}
