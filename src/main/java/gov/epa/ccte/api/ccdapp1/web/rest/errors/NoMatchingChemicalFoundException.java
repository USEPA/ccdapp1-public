package gov.epa.ccte.api.ccdapp1.web.rest.errors;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class NoMatchingChemicalFoundException extends RuntimeException  {

    private String[] errors;

    public NoMatchingChemicalFoundException(List<String> errorMsgs) {
        // super(errorMsg)
        log.debug("Search word exception - {}", errorMsgs.toString());

        errors = errorMsgs.toArray(new String[0]);
    }

    public String[] getErrors(){
     return errors;
    }
}
