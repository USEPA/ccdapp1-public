package gov.epa.ccte.api.ccdapp1.web.rest.search;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ProductResult;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchProductDetails;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchProductDetailsRepository;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class SearchProductController {

    private final SearchProductRepository searchProductRepository;
    private final SearchProductDetailsRepository searchProductDetailsRepository;

    public SearchProductController(SearchProductRepository searchProductRepository, SearchProductDetailsRepository searchProductDetailsRepository) {
        this.searchProductRepository = searchProductRepository;
        this.searchProductDetailsRepository = searchProductDetailsRepository;
    }

    @RequestMapping(value = "/search/product/start-with/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<ProductResult> startWith(@PathVariable("word") String word) throws Exception {

        return searchProductRepository.getProductsStartWith(word.toUpperCase());

    }

    @RequestMapping(value = "/search/product/contain/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<ProductResult> contains(@PathVariable("word") String word) throws Exception {

        return searchProductRepository.getProductsContaining(word.toUpperCase());

    }

    @RequestMapping(value = "/search/product/", method = RequestMethod.GET)
    public @ResponseBody
    List<SearchProductDetails> equal(@RequestParam("word") String word) throws Exception {

        log.debug("word = {}", word.toUpperCase());

        return searchProductDetailsRepository.findByModifiedValueEqualsOrderByDtxsid(word.toUpperCase().trim());
    }

}
