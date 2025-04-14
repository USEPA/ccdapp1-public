package gov.epa.ccte.api.ccdapp1.web.rest.search;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchAssay;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchAssayRepository;
import gov.epa.ccte.api.ccdapp1.web.rest.errors.NoMatchingAssayFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class SearchAssayController {

    private final SearchAssayRepository assayRepository;

    public SearchAssayController(SearchAssayRepository assayRepository) {
        this.assayRepository = assayRepository;
    }

    @RequestMapping(value = "/search/assay/start-with/{name}", method = RequestMethod.GET)
    public @ResponseBody
    List<SearchAssay> startWithSearchWordAssay(@PathVariable("name") String name) throws Exception {

        log.debug("assay search start with ", name.toUpperCase());

        return assayRepository.findByModifiedValueStartsWithOrderBySearchMatch(name.toUpperCase())
                .orElseThrow(()-> new NoMatchingAssayFoundException(name));

    }


    @RequestMapping(value = "/search/assay/contain/{name}", method = RequestMethod.GET)
    public @ResponseBody
    List<SearchAssay> containSearchWordAssay(@PathVariable("name") String name) throws Exception {

        log.debug("assay search contain ", name.toUpperCase());

        return assayRepository.findByModifiedValueContainsOrderBySearchMatch(name.toUpperCase())
                .orElseThrow(()-> new NoMatchingAssayFoundException(name));

    }
}
