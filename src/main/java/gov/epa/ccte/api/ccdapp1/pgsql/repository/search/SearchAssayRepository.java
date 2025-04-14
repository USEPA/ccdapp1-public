package gov.epa.ccte.api.ccdapp1.pgsql.repository.search;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchAssay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface SearchAssayRepository extends JpaRepository<SearchAssay, Integer> {

    //Optional<List<SearchAssay>> findByModifiedValueStartsWithOrderBySearchMatchAscSearchWordAsc(@Param("id") String searchWord);
    Optional<List<SearchAssay>> findByModifiedValueContainsOrderBySearchMatch(@Param("id") String searchWord);

    Optional<List<SearchAssay>> findByModifiedValueStartsWithOrderBySearchMatch(@Param("id") String searchWord);
}
