package gov.epa.ccte.api.ccdapp1;


import gov.epa.ccte.api.ccdapp1.service.SearchChemicalService;
import gov.epa.ccte.api.ccdapp1.service.SearchFormulaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchChemicalServiceTest {

    @Autowired
    SearchChemicalService searchChemicalService;

    @Test
    public void searchWordShouldBeUpperCase(){
        String searchWordWithLowerCase = "bpa";

        String returnWord = searchChemicalService.preprocessingSearchWord(searchWordWithLowerCase);


        assertThat(returnWord, is(searchWordWithLowerCase.toUpperCase()));

    }

    @Test
    public void searchWordWithAscii146(){
        String searchWordWithLowerCase = "bpa";

        // This ASCII 146 should convert into single quote.
        String wordWithAscii146 = "N-(1,3-dimethylbutyl)-N’-phenyl-p-phenylenediamine";
        String wordWithSingleQuote = "N (1,3 DIMETHYLBUTYL) N' PHENYL P PHENYLENEDIAMINE";

        String returnWord = searchChemicalService.preprocessingSearchWord(wordWithAscii146);

        assertThat(returnWord, is(wordWithSingleQuote.toUpperCase()));
    }

    @Test
    public void searchWordWithAscii96(){
        String searchWordWithLowerCase = "bpa";

        // This ASCII 146 should convert into single quote.
        String wordWithAscii146 = "N-(1,3-dimethylbutyl)-N`-phenyl-p-phenylenediamine";
        String wordWithSingleQuote = "N (1,3 DIMETHYLBUTYL) N' PHENYL P PHENYLENEDIAMINE";

        String returnWord = searchChemicalService.preprocessingSearchWord(wordWithAscii146);

        assertThat(returnWord, is(wordWithSingleQuote.toUpperCase()));

    }

    @Test
    public void searchWordWithDashCharacter(){
        String searchWordWithLowerCase = "bpa";

        // This ASCII 146 should convert into single quote.
        String wordWithAscii146 = "jwh-007";
        String wordWithSingleQuote = "JWH 007";

        String returnWord = searchChemicalService.preprocessingSearchWord(wordWithAscii146);

        assertThat(returnWord, is(wordWithSingleQuote.toUpperCase()));

    }
}
