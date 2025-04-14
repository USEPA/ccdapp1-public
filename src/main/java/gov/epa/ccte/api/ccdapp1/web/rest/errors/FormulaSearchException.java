package gov.epa.ccte.api.ccdapp1.web.rest.errors;

public class FormulaSearchException extends RuntimeException  {

    public FormulaSearchException(String formula) {
        super("Exact formula search failed for " + formula);
    }
}
