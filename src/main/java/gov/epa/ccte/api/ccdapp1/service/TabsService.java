package gov.epa.ccte.api.ccdapp1.service;

import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchChemicalDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

@Slf4j
@Service
public class TabsService {


    private final SearchChemicalDetailsRepository searchChemicalDetailsRepository;

    public TabsService(SearchChemicalDetailsRepository searchChemicalDetailsRepository) {
        this.searchChemicalDetailsRepository = searchChemicalDetailsRepository;
    }

    public boolean validateIframeUrl(String dtxsid) throws IOException {
        //String link = "https://pubchem.ncbi.nlm.nih.gov/compound/pubChemId#section=BioAssay-Results&embed=true&hide_title=tru";
        // Here is new URL which actually generate 404 status for no data
        String link = "https://pubchem.ncbi.nlm.nih.gov/rest/pug_view/data/compound/pubChemId/JSON/?heading=BioAssay+Results";
        String pubchemCid=getPubchemCid(dtxsid);

        log.debug("PubchemCid for Dtxsid {} is {} ", dtxsid, pubchemCid);

        if(pubchemCid==null){
            return false;
        }
        else {
            String updatedLink = link.replaceAll("pubChemId", pubchemCid);
            URL url = new URL(updatedLink);
            log.debug("updated url is  {} ", url);
            HttpsURLConnection huc = (HttpsURLConnection) url.openConnection();
            huc.setRequestMethod("HEAD");
            return (huc.getResponseCode() == 404);
        }
    }

    public String getPubchemCid(String dtxsid) {

        Integer pubChemCid  = searchChemicalDetailsRepository.getPubchemCid(dtxsid);
        return String.valueOf(pubChemCid);
    }

}
