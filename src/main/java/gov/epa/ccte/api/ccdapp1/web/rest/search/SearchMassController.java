package gov.epa.ccte.api.ccdapp1.web.rest.search;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchMassAndFormula;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchMassAndFormulaRepository;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class SearchMassController {

    private final SearchMassAndFormulaRepository searchMassAndFormulaRepository;

    public SearchMassController(SearchMassAndFormulaRepository searchMassAndFormulaRepository) {
        this.searchMassAndFormulaRepository = searchMassAndFormulaRepository;
    }

    @RequestMapping(value = "/search/mass/{start}/{end}", method = RequestMethod.GET)
    public @ResponseBody
    Page<SearchMassAndFormula> getChemicalsForMassBetween(@PathVariable("start") Double start,
                                                          @PathVariable("end") Double end,
                                                          @RequestParam(value = "mass", required = false, defaultValue = "0.0") Double mass, Pageable pageable) throws Exception {

        log.debug("mass search start with {} to {}", start, end);

        return searchMassAndFormulaRepository.getMassValues(start, end, mass, pageable);
    }

    @RequestMapping(value = "/search/mass/count/{start}/{end}", method = RequestMethod.GET)
    public @ResponseBody
    Long getCountForMassBetween(@PathVariable("start") Double start, @PathVariable("end") Double end) throws Exception {

        log.debug("get count for mass between {} to {}", start, end);

        return searchMassAndFormulaRepository.countByMonoisotopicMassBetweenAndDtxsidIsNot(start, end, "DTXSID00000000");
    }

    // this created for SSS project
    @RequestMapping(value = "/search/mass2/{start}/{end}", method = RequestMethod.GET)
    public @ResponseBody
    List<SearchMassAndFormula> getChemicalsForMassBetween2(@PathVariable("start") Double start,
                                                           @PathVariable("end") Double end,
                                                           @Parameter(description="Toxval") @RequestParam(value = "toxval", required = false, defaultValue = "") String toxval,
                                                           @Parameter(description = "Chemicals with atomics") @RequestParam(name = "includes", required = false)ArrayList<String> includes,
                                                           @Parameter(description = "Chemicals without atomics") @RequestParam(name = "excludes", required = false)ArrayList<String> excludes,
                                                           @RequestParam(value = "mass", required = false, defaultValue = "0.0") Double mass) throws Exception {

        log.debug("mass2 search start with {} to {} - toxval = {}", start, end, toxval);

        List<SearchMassAndFormula> resultCompounds;

        if(toxval.equalsIgnoreCase("Y")) {
            resultCompounds = searchMassAndFormulaRepository.getMassValues3(start, end, mass, "Y");
        }else {
            resultCompounds = searchMassAndFormulaRepository.getMassValues2(start, end, mass);
        }

        if(includes != null || excludes != null){
            return filterResult(resultCompounds, includes, excludes);
        }else{
            return resultCompounds;
        }
    }

    private List<SearchMassAndFormula> filterResult(List<SearchMassAndFormula> resultCompounds, ArrayList<String> includes, ArrayList<String> excludes) {
        ArrayList<SearchMassAndFormula> returnValues = new ArrayList<>();

        for(SearchMassAndFormula compound : resultCompounds){
            if(includes != null && stringExist(compound.getMolFormula(), includes) == true)
                returnValues.add(compound);
            if(excludes != null && stringExist(compound.getMolFormula(), excludes) == false)
                returnValues.add(compound);
        }

        return returnValues;
    }

    private boolean stringExist(String formula, ArrayList<String> elements) {
        return elements.stream().anyMatch(formula::contains);
    }
}
