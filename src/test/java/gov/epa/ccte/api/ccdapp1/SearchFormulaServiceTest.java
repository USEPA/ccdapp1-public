package gov.epa.ccte.api.ccdapp1;


import gov.epa.ccte.api.ccdapp1.service.SearchFormulaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchFormulaServiceTest {

    @Autowired
    SearchFormulaService searchFormulaService;

    @Test
    public void formulaWithoutRangeShouldNotChange(){
        String formulaWihtoutRange = "C15H16O2";

        List<String> returnFormula = searchFormulaService.getValidFormulas(formulaWihtoutRange);

        assertThat(returnFormula, hasSize(1));

        assertThat(returnFormula, hasItem(formulaWihtoutRange));

    }

    @Test
    public void formulaWithRangeShouldHaveGeneratedForumulas(){
        String formulaWithRange = "C6H(8-10)";

        List<String> returnFormulas = searchFormulaService.getValidFormulas(formulaWithRange);

        assertThat(returnFormulas, hasSize(3));

        assertThat(returnFormulas, hasItem("C6H8"));

    }

    @Test
    public void spacesInFormulaShouldBeIgnore(){
        String formulaWihSpace = "C15 H16 O2";
        String formulaWihOutSpace = "C15H16O2";

        List<String> returnFormula = searchFormulaService.getValidFormulas(formulaWihSpace);

        assertThat(returnFormula, hasSize(1));

        assertThat(returnFormula, hasItem(formulaWihOutSpace));

    }

    @Test
    public void removeAtomsWithZero(){
        List<String> preProcessedFormula = new ArrayList<>();
        Collections.addAll(preProcessedFormula, "Co0", "Co", "Co2");

        List<String> processedFormula = new ArrayList<>();
        Collections.addAll(processedFormula, "", "Co", "Co2");

        List<String> returnFormula = searchFormulaService.removeAtomsWithZero(preProcessedFormula);

        assertTrue(processedFormula.size() == returnFormula.size() && processedFormula.containsAll(returnFormula) && returnFormula.containsAll(processedFormula));

    }

    @Test
    public void parseAtomsTest(){
       String element ="C6";
        String atom ="C";

        List<String> parsedAtoms = new ArrayList<>();
        Collections.addAll(parsedAtoms, "C6");

        List<String> result = searchFormulaService.parseAtoms(element,atom);

        assertTrue(result.size() == parsedAtoms.size() && result.containsAll(parsedAtoms) && parsedAtoms.containsAll(result));

    }

    @Test
    public void parseAtomsRangeTest(){
        String element ="Co(0-2)";
        String atom ="Co";

        List<String> parsedAtoms = new ArrayList<>();
        Collections.addAll(parsedAtoms, "Co0","Co","Co2");

        List<String> result = searchFormulaService.parseAtoms(element,atom);

        assertTrue(result.size() == parsedAtoms.size() && result.containsAll(parsedAtoms) && parsedAtoms.containsAll(result));

    }

    @Test
    public void testParseFormulaWithOrder() {
        String formula = "H2O";
        Map<String, ArrayList<String>> expected = new LinkedHashMap<>();
        expected.put("H", new ArrayList<>(Arrays.asList("H2")));
        expected.put("O", new ArrayList<>(Arrays.asList("O")));

        Map<String, ArrayList<String>> result = searchFormulaService.parseFormula(formula);

        assertEquals(expected, result);
    }
}
