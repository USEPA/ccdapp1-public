package gov.epa.ccte.api.ccdapp1.web.rest;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.BioActivityRequest;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity.Bioactivity;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.bioactivity.BioactivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class BioactivityController {

    private BioactivityRepository bioactivityRepository;

    public BioactivityController(BioactivityRepository bioactivityRepository) {
        this.bioactivityRepository = bioactivityRepository;
    }

    @RequestMapping(value = "/search/bioactivity/with/asaycomponentendpointnames", method = RequestMethod.POST)
    public @ResponseBody
    List<Bioactivity> searchWithDtxsidAndAssayComponentnames(@RequestBody BioActivityRequest bioActivityRequest){
        if (bioActivityRequest.getRepresentativeSample().equalsIgnoreCase("TRUE")) {
            return bioactivityRepository.findByDtxsidAndAssayComponentEndpointNmIn(bioActivityRequest.getDtxsid(), bioActivityRequest.getAsayComponentEndpointNames());
        } else {
            return bioactivityRepository.findByDtxsidAndAssayComponentEndpointNameIn(bioActivityRequest.getDtxsid(), bioActivityRequest.getAsayComponentEndpointNames());
        }
    }
}

