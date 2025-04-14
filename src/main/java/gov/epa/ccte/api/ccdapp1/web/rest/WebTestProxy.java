package gov.epa.ccte.api.ccdapp1.web.rest;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.springframework.http.HttpMethod.POST;

@Slf4j
@BasePathAwareController
@CrossOrigin
public class WebTestProxy {

    @PostMapping(value = "/webtest/predict", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> predict(@RequestBody Object body, HttpServletRequest request, HttpServletResponse response, HttpMethod httpMethod) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity(body,headers);

//        ResponseEntity<Object> res = restTemplate.exchange("https://comptox.epa.gov/dashboard/aadashboard/api/predict",
//                POST, entity, Object.class );
//        ResponseEntity<Object> res = restTemplate.exchange("http://v2626umcth840.rtord.epa.gov:8080/api/predict",
//                POST, entity, Object.class );
        ResponseEntity<Object> res = restTemplate.exchange("https://ccte-ccd-aadashboard.epa.gov/api/predict",
                POST, entity, Object.class );
        //
        return res;
    }

    @GetMapping(value = "/webtest/metadata")
    public ResponseEntity<Object> predict() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
        HttpEntity entity = new HttpEntity(headers);

        //
        //String res = restTemplate.exchange("https://comptox.epa.gov/dashboard/aadashboard/api/metadata", HttpMethod.GET, entity, String.class).getBody();
        //ResponseEntity<Object> res = restTemplate.exchange("https://comptox.epa.gov/dashboard/aadashboard/api/metadata", HttpMethod.GET, entity, Object.class);
        //ResponseEntity<String> res = restTemplate.exchange("http://v2626umcth840.rtord.epa.gov:8080/api/metadata", HttpMethod.GET, entity, String.class);
//        String baseUrl = "http://v2626umcth840.rtord.epa.gov:8080/api/metadata";
        String baseUrl = "https://ccte-ccd-aadashboard.epa.gov/api/metadata";
        URI uri = new URI(baseUrl);

        ResponseEntity<Object> res = restTemplate.getForEntity(uri, Object.class);

        return res;
    }

}
