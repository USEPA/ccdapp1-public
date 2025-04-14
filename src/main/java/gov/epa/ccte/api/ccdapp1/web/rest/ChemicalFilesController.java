package gov.epa.ccte.api.ccdapp1.web.rest;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ChemicalFiles;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.ChemicalFilesRepository;
import gov.epa.ccte.api.ccdapp1.service.ChemicalConverterService;
import gov.epa.ccte.api.ccdapp1.service.SdfService;
import gov.epa.ccte.api.ccdapp1.web.rest.errors.NoMolTypeFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.MediaType.IMAGE_PNG;
import static org.springframework.http.MediaType.TEXT_PLAIN;

@Slf4j
@CrossOrigin
@RestController
public class ChemicalFilesController {

    private final ChemicalFilesRepository repository;
    private final ChemicalConverterService chemicalConverterService;
    private final SdfService sdfService;

    public ChemicalFilesController(ChemicalFilesRepository repository, ChemicalConverterService chemicalConverterService, SdfService sdfService) {
        this.repository = repository;
        this.chemicalConverterService = chemicalConverterService;
        this.sdfService = sdfService;
    }

    @RequestMapping(value = "/chemical-files/sdf/by-dtxsid/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getSdfForDtxsid(@PathVariable("id") String id) throws IOException {

        log.debug("dtxsid = {}", id);

        ChemicalFiles chemical = repository.findByDtxsid(id);
        String sdfContent = sdfService.convertToSdf(chemical);

        return ResponseEntity.ok().contentType(TEXT_PLAIN).body(sdfContent);
    }

    @RequestMapping(value = "/chemical-files/image/by-dtxcid/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<byte[]> getImageForDtxcid(@PathVariable("id") String id) throws IOException {
        log.debug("dtxsid = {}", id);

        byte[] image = repository.getMolImageForDtxcid(id);

        return ResponseEntity.ok().contentType(IMAGE_PNG).body(image);
    }

    @RequestMapping(value = "/chemical-files/image/by-dtxsid/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<byte[]> getImageForDtxsid(@PathVariable("id") String id) throws IOException {

        log.debug("dtxsid = {}", id);

        byte[] image = repository.getMolImageForDtxsid(id);

        return ResponseEntity.ok().contentType(IMAGE_PNG).body(image);
    }

    @RequestMapping(value = "/chemical-files/mol/by-dtxsid/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getMolFileForDtxsid(@PathVariable("id") String id, @RequestParam(name = "type", required = false) String type) throws IOException {

        log.debug(" mol file for {} with type = {}", id, type);

        String molFile = repository.getMolFileForDtxsid(id);


        String fileName = id + ".mol";
        String fileContent;

        if(StringUtils.isEmpty(type)){
            fileContent = molFile;
        }else if (type.equalsIgnoreCase("v2000")){
            ChemicalConverterService.MolV3000 molV3000 = new ChemicalConverterService.MolV3000(molFile);
            ChemicalConverterService.MolV2000 molV2000 = chemicalConverterService.convert(molV3000);

            fileContent = molV2000.getContent();
        }else{
            throw new NoMolTypeFoundException(type);
        }

        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.set("Content-Disposition", "attachment; filename=" + fileName);

        return ResponseEntity.ok().contentType(TEXT_PLAIN).headers(responseHeaders).body(fileContent);
    }

    @RequestMapping(value = "/chemical-files/mol/by-dtxcid/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getMolFileForDtxcid(@PathVariable("id") String id, @RequestParam(name = "type", required = false) String type) throws IOException {

        log.debug(" mol file for {} with type = {}", id, type);

        //ChemicalFiles chemicalFiles = chemicalFilesRepository.findByDtxcid(id);
        String molFile = repository.getMolFileForDtxcid(id);

        String fileName = id + ".mol";
        String fileContent;

        if(StringUtils.isEmpty(type)){
            fileContent = molFile;
        }else if (type.equalsIgnoreCase("v2000")){
            ChemicalConverterService.MolV3000 molV3000 = new ChemicalConverterService.MolV3000(molFile);
            ChemicalConverterService.MolV2000 molV2000 = chemicalConverterService.convert(molV3000);

            fileContent = molV2000.getContent();
        }else{
            throw new NoMolTypeFoundException(type);
        }

        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.set("Content-Disposition", "attachment; filename=" + fileName);

        return ResponseEntity.ok().contentType(TEXT_PLAIN).headers(responseHeaders).body(fileContent);
    }

}
