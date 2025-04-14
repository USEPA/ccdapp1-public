package gov.epa.ccte.api.ccdapp1.web.rest;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.links.LinkDisplay;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.links.LinksRepository;
import gov.epa.ccte.api.ccdapp1.web.rest.errors.NoDtxsidFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
//@CrossOrigin(origins = {"http://localhost:3003", "http://comptox-int-edge.epa.gov", "http://ccte-ccd-stg.epa.gov"})
@CrossOrigin
@BasePathAwareController
public class CcdlinksController {

    private final LinksRepository linksRepository;

    public CcdlinksController(LinksRepository linksRepository) {
        this.linksRepository = linksRepository;
    }

    @RequestMapping(value = "/chemical-links/search/by-dtxsid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getLinksByDtxsid(
            @PathVariable("id") String id) {

        List<LinkDisplay> linkDisplay = linksRepository.findLinksByDtxsid(id);

        if (linkDisplay.size() == 0)
            throw new NoDtxsidFoundException(id);

        for (LinkDisplay l : linkDisplay) {
            if(l.getName().equalsIgnoreCase("SeqAPASS")){
                l.setVisible(true);
            }
            else if (l.getParamValue() != null) {
                l.setUrl(l.getUrl().replace("%s", l.getParamValue()));
                l.setVisible(true);
            } else l.setVisible(false);
        }

        Map<String, List<LinkDisplay>> byLabel
                = linkDisplay.stream()
                .collect(Collectors.groupingBy(LinkDisplay::getLabel));
        return ResponseEntity.ok().body(byLabel);
    }
}

