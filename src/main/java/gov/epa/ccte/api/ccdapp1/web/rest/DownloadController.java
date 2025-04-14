package gov.epa.ccte.api.ccdapp1.web.rest;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.Downloads;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.DownloadsRepository;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@BasePathAwareController
public class DownloadController {
    private final DownloadsRepository downloadsRepository;

    public DownloadController(DownloadsRepository downloadsRepository) {
        this.downloadsRepository = downloadsRepository;
    }

    @RequestMapping(value = "/all-downloads/", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Downloads> getAllDownloads() throws Exception {

        return downloadsRepository.findAll();

    }
}
