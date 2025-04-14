package gov.epa.ccte.api.ccdapp1.web.rest.errors;

public class InChiKeyGenerationErrorException extends RuntimeException {

    public InChiKeyGenerationErrorException() {
        super("InChIKey not computable for provided structure");
    }
}
