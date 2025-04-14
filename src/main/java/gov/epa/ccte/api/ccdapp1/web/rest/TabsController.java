package gov.epa.ccte.api.ccdapp1.web.rest;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs.TabDisplayDetail;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.TabsRepository;
import gov.epa.ccte.api.ccdapp1.service.TabsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RepositoryRestController
//@CrossOrigin(origins = {"http://localhost:3003", "http://comptox-int-edge.epa.gov", "http://ccte-ccd-stg.epa.gov"})
public class TabsController {
    private final TabsRepository tabsRepository;

    private final TabsService tabsService;

    public TabsController(TabsRepository tabsRepository, TabsService tabsService) {
        this.tabsRepository = tabsRepository;
        this.tabsService = tabsService;
    }


    @RequestMapping(value = "/tabs/by-dtxsid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<TabDisplayDetail> tabsForDtxsid(@PathVariable("id") String id) throws Exception {
        log.debug("dtxsid = {} ", id);

        List<TabDisplayDetail> tabs = tabsRepository.findTabsBydtxsid(id);

        if (tabs.isEmpty()) {
            return tabs; // for no data we will return empty array
        } else {
            for (TabDisplayDetail tab : tabs) {
                if (tab.getLabelDisplay().equalsIgnoreCase("pubchem") && (tabsService.validateIframeUrl(id))) {
                    tab.setDisable(true);
                }
            }
            return tabs;
        }
    }


    @RequestMapping(value = "/tabs/by-dtxcid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<TabDisplayDetail> tabsForDtxcid(@PathVariable("id") String id) throws Exception {
        log.debug("dtxcid = {}", id);

        List<TabDisplayDetail> tabs = tabsRepository.findTabsBydtxcid(id);

        log.debug("{} tabs records found for dtxcid = {}", tabs.size(), id);

        return tabs;
    }

    @RequestMapping(value = "/tabs/by-dtxsid/{id}/{list}", method = RequestMethod.GET)
    @ResponseBody
    public List<TabDisplayDetail> tabsForDtxsidWithList(@PathVariable("id") String id, @PathVariable("list") String listName) throws Exception {
        log.debug("dtxsid = {}, list = {}", id, listName);

        List<TabDisplayDetail> tabs = tabsRepository.findTabsBydtxsidAndListName(id, listName);

        log.debug("{} tabs records found for dtxsid = {}, list = {}", tabs.size(), id, listName);

        return tabs;
    }


}
