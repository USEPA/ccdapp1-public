package gov.epa.ccte.api.ccdapp1.web.rest.errors;

public class MassSearchException  extends RuntimeException  {

    public MassSearchException(Double start, Double end) {
        super("Search mass got error with " + start + " and " + end);
    }
}
