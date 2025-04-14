package gov.epa.ccte.api.ccdapp1.web.rest.errors;

public class NoDtxsidFoundException extends RuntimeException  {

    public NoDtxsidFoundException(String searchWord) {
        super("No matching dtxsid found for " + searchWord);
    }
}
