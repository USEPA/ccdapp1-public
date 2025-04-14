package gov.epa.ccte.api.ccdapp1.web.rest.errors;

public class NoMatchingAssayFoundException  extends RuntimeException  {

    public NoMatchingAssayFoundException(String searchWord) {
        super("No matching assay or gene found for " + searchWord);
    }
}