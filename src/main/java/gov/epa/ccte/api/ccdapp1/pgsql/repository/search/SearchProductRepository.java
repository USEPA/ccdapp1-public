package gov.epa.ccte.api.ccdapp1.pgsql.repository.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ProductResult;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface SearchProductRepository extends JpaRepository<SearchProduct, Integer> {

    @RestResource(exported = false)
    @Query(value = "select distinct new gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ProductResult(" +
            " d.searchValue, d.searchName, d.searchValueDesc)" +
            " from SearchProduct d  " +
            " where d.modifiedValue like :word% ")
    List<ProductResult> getProductsStartWith(@Param("word") String modifiedValue);


    @RestResource(exported = false)
    @Query(value = "select distinct new gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ProductResult(" +
            " d.searchValue, d.searchName, d.searchValueDesc)" +
            " from SearchProduct d  " +
            " where d.modifiedValue like %:word%  and d.searchName <> 'CPCat Use Category'")
    List<ProductResult> getProductsContaining(@Param("word") String modifiedValue);

}
