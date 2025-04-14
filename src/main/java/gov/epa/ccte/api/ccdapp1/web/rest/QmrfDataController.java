package gov.epa.ccte.api.ccdapp1.web.rest;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.QmrfData;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.QmrfDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_PDF;

@Slf4j
@Controller
public class QmrfDataController {

    private final QmrfDataRepository qmrfDataRepository;

    public QmrfDataController(QmrfDataRepository qmrfDataRepository) {
        this.qmrfDataRepository = qmrfDataRepository;
    }

    @RequestMapping(value = "/qmrfdata/file/by-modelid/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<byte[]> getPdfForModelId(@PathVariable("id") int modelId) throws IOException {
        QmrfData file = qmrfDataRepository.findByModelId(modelId);
        return ResponseEntity.ok().contentType(APPLICATION_PDF).body(file.getReportPdf());

    }
}
