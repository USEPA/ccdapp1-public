package gov.epa.ccte.api.ccdapp1.web.rest.errors;

public class NoMolTypeFoundException extends RuntimeException  {

    public NoMolTypeFoundException(String molType) {
        super("Mol file type = " + molType + " is not supported type.");
    }
}