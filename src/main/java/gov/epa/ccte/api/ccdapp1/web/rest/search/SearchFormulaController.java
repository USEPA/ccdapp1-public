package gov.epa.ccte.api.ccdapp1.web.rest.search;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchMassAndFormula;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchMsReadyFormula;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchMassAndFormulaRepository;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchMsReadyFormulaRepository;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchMsReadyRepository;
import gov.epa.ccte.api.ccdapp1.service.SearchFormulaService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@RestController
public class SearchFormulaController {

    private final SearchMassAndFormulaRepository searchMassAndFormulaRepository;
    private final SearchMsReadyFormulaRepository searchMsReadyFormulaRepository;
    private final SearchMsReadyRepository searchMsReadyRepository;

    private final SearchFormulaService formulaService;

    public SearchFormulaController(SearchMassAndFormulaRepository searchMassAndFormulaRepository, SearchMsReadyFormulaRepository searchMsReadyFormulaRepository, SearchFormulaService formulaService,SearchMsReadyRepository searchMsReadyRepository) {
        this.searchMassAndFormulaRepository = searchMassAndFormulaRepository;
        this.searchMsReadyFormulaRepository = searchMsReadyFormulaRepository;
        this.formulaService = formulaService;
        this.searchMsReadyRepository=searchMsReadyRepository;
    }

    @RequestMapping(value = "/search/formula/exact/{formula}", method = RequestMethod.GET)
    public @ResponseBody
    List<SearchMassAndFormula> getChemicalsForExactFormula(@Parameter(description="Chemical formula for searching") @PathVariable("formula") String formula,
                                                           @Parameter(description="Toxval") @RequestParam(value = "toxval", required = false, defaultValue = "") String toxval
                                    ) throws Exception {

        log.debug("excat formula search for {} and toxval={}", formula, toxval);

        // check if formula has range defined, it that case get the formula list
        if(formula.contains("(")){
            List<String> formulas = formulaService.getValidFormulas(formula);

            log.debug("formula search for {}", formulas.toString());

            if(toxval.equalsIgnoreCase("Y"))
                return searchMassAndFormulaRepository.getExactFormulaResultWithToxVal(formulas, "Y");
            else
                return searchMassAndFormulaRepository.getExactFormulaResult(formulas);
        }else{
            if(toxval.equalsIgnoreCase("Y"))
                return searchMassAndFormulaRepository.getExactFormulaResultWithToxVal(formula, "Y");
            else {
                return searchMassAndFormulaRepository.getExactFormulaResult(formula);
            }
        }
    }

    @RequestMapping(value = "/search/formula/msready/{formula}", method = RequestMethod.GET)
    public @ResponseBody
    List<SearchMsReadyFormula> getChemicalsForMsReadyFormula(@Parameter(description="Chemical formula for searching") @PathVariable("formula") String formula,
                                                             @Parameter(description="Toxval") @RequestParam(value = "toxval", required = false, defaultValue = "") String toxval) throws Exception {

        log.debug("Ms Ready formula search for {} and toxval={}", formula, toxval);
        // check if formula has range defined, it that case get the formula list
        if(formula.contains("(")){
            List<String> formulas = formulaService.getValidFormulas(formula);

            log.debug("formula search for {}", formulas.toString());

        return searchMsReadyFormulaRepository.getMsReadyFormula(formulas);
        }else
            return searchMsReadyFormulaRepository.getMsReadyFormula(formula);

    }

    @RequestMapping(value = "/search/formula/count/{formula}", method = RequestMethod.GET)
    public @ResponseBody
    Long getChemicalsCountForExactFormula(@Parameter(description="Chemical formula for getting count") @PathVariable("formula") String formula) throws Exception {

        log.debug("count for {}", formula);
        return searchMsReadyRepository.countByMolFormulaIsAndDtxsidIsNot(formula, "DTXSID00000000");

    }

    @RequestMapping(value = "/search/formula-range/{formula}", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getFormulasForGivenRange(@Parameter(description="Chemical formula with range") @PathVariable("formula") String formula) throws Exception {

        log.debug("Formula with range {}", formula);

        return formulaService.getValidFormulas(formula);
    }

    @RequestMapping(value = "/search/formula/msready/contains/{formula}", method = RequestMethod.GET)
    public @ResponseBody List<SearchMsReadyFormula> getChemicalsContainingMsReadyFormula(
            @Parameter(description=" chemical formula for searching") @PathVariable("formula") String formula) throws Exception {

        log.debug("Searching for MS Ready formulas containing '{}'", formula);

        //  fetching formulas that contain the given substring without checking for a range
        //also removing null records from the response
        return searchMsReadyFormulaRepository.getMsReadyFormulaContaining(formula)
                .stream().filter(Objects::nonNull).collect(Collectors.toList());

    }
}
