package gov.epa.ccte.api.ccdapp1.web.rest.search;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.*;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchChemicalDetailsRepository;
import gov.epa.ccte.api.ccdapp1.service.SearchChemicalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import java.util.Arrays;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class SearchChemicalController {

    private final SearchChemicalService chemicalService;
    private final SearchChemicalDetailsRepository searchChemicalDetailsRepository;
    private final List<String> searchMatchWithoutInchikey;
    private final List<String> searchMatchAll;

    
    public SearchChemicalController( SearchChemicalService chemicalService, SearchChemicalDetailsRepository searchChemicalDetailsRepository) {
        this.chemicalService = chemicalService;
        this.searchChemicalDetailsRepository = searchChemicalDetailsRepository;
        searchMatchWithoutInchikey = Arrays.asList("Deleted CAS-RN","PC-Code","Substance_id","Approved Name","Alternate CAS-RN",
                "CAS-RN","Synonym","Integrated Source CAS-RN","DSSTox_Compound_Id","Systematic Name","Integrated Source Name",
                "Expert Validated Synonym","Synonym from Valid Source","FDA CAS-Like Identifier","DSSTox_Substance_Id", "EHCA Number", "EC Number");
        searchMatchAll = Arrays.asList("Deleted CAS-RN","PC-Code","Substance_id","Approved Name","Alternate CAS-RN",
                "CAS-RN","Synonym","Integrated Source CAS-RN","DSSTox_Compound_Id","Systematic Name","Integrated Source Name",
                "Expert Validated Synonym","Synonym from Valid Source","FDA CAS-Like Identifier","DSSTox_Substance_Id",
                "InChIKey", "Indigo InChIKey", "EHCA Number", "EC Number");
    }

// -- start with (use with type ahead search)
    // short result
    @RequestMapping(value = "/search/chemical/start-with/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<ChemicalShortResult> startWithShort(@PathVariable("word") String word, @RequestParam(name = "list", required = false) String listName ) throws Exception {

        String searchWord = chemicalService.preprocessingSearchWord(word);

        log.debug("input search word = {} and process search word = {}. list name = {}", word, searchWord, listName);

        List<ChemicalShortResult> searchResult;

        if (StringUtils.isEmpty(listName)) {
            // avoid InChIKey
            if(searchWord.length() > 13){
                searchResult =  searchChemicalDetailsRepository.startWithShort(searchWord+"%");
            }else{
                log.debug("searchWord = {}", searchWord);
                searchResult =  searchChemicalDetailsRepository.startWithShortWithoutInchi(searchWord+"%");
            }
            log.debug("{} records match for {}", searchResult.size(), word);

            return removeDuplicatesFromChemicalShortResult( searchResult);
        } else{
            searchResult = searchChemicalDetailsRepository.startWithShortWithList(searchWord+"%", listName);
            return removeDuplicatesFromChemicalShortResult(searchResult);
        }

    }

    // long result
    @RequestMapping(value = "/search/chemical/start-with-details/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<ChemicalLongResult> startWithDetails(@PathVariable("word") String word) throws Exception {
        String searchWord = chemicalService.preprocessingSearchWord(word);
        log.debug("input search word = {} and process search word = {}", word, searchWord);

        List<ChemicalLongResult> searchResult;

        // avoid InChIKey
        if(searchWord.length() > 13){
            searchResult =  searchChemicalDetailsRepository.startWithLong(searchWord+"%");
        }else{
            searchResult =  searchChemicalDetailsRepository.startWithLongWithoutInchi(searchWord+"%");
        }
        log.debug("{} records match for {}", searchResult.size(), word);

        return removeDuplicatesFromChemicalLongResult( searchResult);

    }

    @RequestMapping(value = "/search/chemical/start-with/count/{word}", method = RequestMethod.GET)
    public @ResponseBody
    Long startWithCount(@PathVariable("word") String word, @RequestParam(name = "list", required = false) String listName ) throws Exception {

        String searchWord = chemicalService.preprocessingSearchWord(word);

        log.debug("input search word = {} and process search word = {}. list name = {}", word, searchWord, listName);

        if (StringUtils.isEmpty(listName)) {
            return searchChemicalDetailsRepository.startWithCount(searchWord).get();
        } else{
            return searchChemicalDetailsRepository.startWithCountWithListName(searchWord, listName).get();
        }
    }


// -- contains (substring search)
    @RequestMapping(value = "/search/chemical/contain/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<ChemicalShortResult> containSearchWord(@PathVariable("word") String word) throws Exception {
        String searchWord = chemicalService.preprocessingSearchWord(word);
        log.debug("input search word = {} and process search word = {}", word, searchWord);

        //List<ChemicalShortResult> result =searchChemicalDetailsRepository.findByModifiedValueContainsOrderByRankAscSearchMatchAsc(searchWord, ChemicalShortResult.class);
        List<ChemicalShortResult> result =searchChemicalDetailsRepository.containShort("%"+ searchWord + "%");
        log.debug("result = {}", result.size());

        return result;
    }

    @RequestMapping(value = "/search/chemical/contain-dtxsid/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<String> containSearchForDtxsid(@PathVariable("word") String word, @RequestParam(name = "list", required = false) String listName) throws Exception {

        String searchWord = chemicalService.preprocessingSearchWord(word);

        log.debug("input search word = {} and process search word = {}. list name = {}", word, searchWord, listName);

        List<String> dtxsids;

        if (StringUtils.isEmpty(listName)) {
            dtxsids = searchChemicalDetailsRepository.containSearchForDtxsid(searchWord);
        } else{
            dtxsids = searchChemicalDetailsRepository.containSearchForDtxsidWithListName(searchWord, listName);
        }

        return dtxsids;
    }

    @RequestMapping(value = "/search/chemical/contain-with-details/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<ChemicalLongResult> searchContainWithDetails(@PathVariable("word") String word) throws Exception {
        String searchWord = chemicalService.preprocessingSearchWord(word);
        log.debug("input search word = {} and process search word = {}", word, searchWord);

        List<ChemicalLongResult> result =searchChemicalDetailsRepository.containLong("%" + searchWord + "%");
        log.debug("result = {}", result.size());

        return removeDuplicatesFromChemicalLongResult(result);

    }

    @RequestMapping(value = "/search/chemical/contain-count/{word}", method = RequestMethod.GET)
    public @ResponseBody
    Long containSearchWordCount (@PathVariable("word") String word ) throws Exception {

        String searchWord = chemicalService.preprocessingSearchWord(word);

        log.debug("input search word = {} and process search word = {}", word, searchWord);

        return searchChemicalDetailsRepository.countContain(searchWord).get();
                //.orElseThrow(()-> new NoMatchingChemicalFoundException(chemicalService.getErrorMsg(word)));

    }

// -- equal  (use when user hit enter key with some search work)
    @RequestMapping(value = "/search/chemical/equal/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<ChemicalShortResult> equal(@PathVariable("word") String word) throws Exception {
        String searchWord = chemicalService.preprocessingSearchWord(word);
        log.debug("input search word = {} and process search word = {}", word, searchWord);

        List<ChemicalShortResult>  searchResult = searchChemicalDetailsRepository.equalShort(searchWord);

        return removeDuplicatesFromChemicalShortResult(searchResult);

/*        if(searchResult.size() > 0){
            return searchResult;
        }else{
            throw new NoMatchingChemicalFoundException(chemicalService.getErrorMsg(word));
        }*/
    }


    // this one is used for InchiSkeleten search - used in chemical detail page

    @RequestMapping(value = "/search/chemical/equal-with-detail/{word}", method = RequestMethod.GET)
    public @ResponseBody
    List<ChemicalLongResult> equalWithDetail(@PathVariable("word") String word) throws Exception {
        String searchWord = chemicalService.preprocessingSearchWord(word);
        log.debug("input search word = {} and process search word = {}", word, searchWord);

        List<ChemicalLongResult>  searchResult = searchChemicalDetailsRepository.equalLong(searchWord);

        log.debug("search result has {} records.", searchResult.size());

        return removeDuplicatesFromChemicalLongResult(searchResult);


/*        if(searchResult.size() > 0){
            return searchResult;
        }else{
            throw new NoMatchingChemicalFoundException(chemicalService.getErrorMsg(word));
        }*/

    }


    @RequestMapping(value = "/search/chemical/structure/", method = RequestMethod.GET)
    public @ResponseBody
    List<ChemicalShortResult> structureSearch(@RequestParam("smiles") String structure) throws Exception {
      
        String smilesDecoded = URLDecoder.decode(structure, StandardCharsets.UTF_8.name());
      
        log.debug("input search structure = {} ", smilesDecoded);
      
        List<ChemicalShortResult> searchResult = searchChemicalDetailsRepository.equalStructureShort(smilesDecoded);

        return removeDuplicatesFromChemicalShortResult(searchResult);

/*        if(searchResult.size() > 0){
            return searchResult;
        }else{
            throw new NoMatchingChemicalFoundException(chemicalService.getErrorMsg(word));
        }*/
    }

    @RequestMapping(value = "/search/chemical/structure-with-detail/", method = RequestMethod.GET)
    public @ResponseBody
    List<ChemicalLongResult> structureSearchWithDetail(@RequestParam("smiles") String structure) throws Exception {

        String smilesDecoded = URLDecoder.decode(structure, StandardCharsets.UTF_8.name());
      
        log.debug("input structure = {} ", smilesDecoded);

        List<ChemicalLongResult> searchResult = searchChemicalDetailsRepository.equalStructureLong(smilesDecoded);

        log.debug("search result has {} records.", searchResult.size());

        return removeDuplicatesFromChemicalLongResult(searchResult);


/*        if(searchResult.size() > 0){
            return searchResult;
        }else{
            throw new NoMatchingChemicalFoundException(chemicalService.getErrorMsg(word));
        }*/

    }

    private List<SearchChemicalDetails> removeDuplicatesFromSearchChemicalDetailsResult(List<SearchChemicalDetails> chemicals) {
        return chemicalService.removeDuplicatesForChemicalDetails(chemicals);
    }

    private List<ChemicalShortResult> removeDuplicatesFromChemicalShortResult(List<ChemicalShortResult> chemicals) {
        return chemicalService.removeDuplicatesForShort(chemicals);
    }


    private List<ChemicalLongResult> removeDuplicatesFromChemicalLongResult(List<ChemicalLongResult> chemicals) {
        return chemicalService.removeDuplicatesForLong(chemicals);
    }
}
