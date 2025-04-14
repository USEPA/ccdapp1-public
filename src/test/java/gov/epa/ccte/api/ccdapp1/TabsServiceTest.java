package gov.epa.ccte.api.ccdapp1;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchChemicalDetails;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.search.SearchChemicalDetailsRepository;
import gov.epa.ccte.api.ccdapp1.service.TabsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TabsServiceTest {

    @Mock
    private SearchChemicalDetailsRepository mockSearchChemicalDetailsRepository;

    private TabsService tabsServiceUnderTest;

    @Before
    public void setUp() {
        tabsServiceUnderTest = new TabsService(mockSearchChemicalDetailsRepository);
    }

    @Test
    public void testValidateIframeUrl() throws Exception {
        // Setup

        // Configure SearchChemicalDetailsRepository.findByDtxsidEquals(...).
        final SearchChemicalDetails searchChemicalDetails = new SearchChemicalDetails();
        searchChemicalDetails.setSearchMatch("Synonym");
        searchChemicalDetails.setSearchWord("4, 4'-Dihydroxydiphenylpropane");
        searchChemicalDetails.setModifiedValue("4, 4' DIHYDROXYDIPHENYLPROPANE");
        searchChemicalDetails.setRank(15);
        when(mockSearchChemicalDetailsRepository.findByDtxsidEquals("DTXSID7080182")).thenReturn(searchChemicalDetails);

        // Run the test
        final boolean result = tabsServiceUnderTest.validateIframeUrl("DTXSID7080182");

        // Verify the results
        assertThat(result).isTrue();
    }

//    @Test
//    public void testValidateIframeUrl_ThrowsIOException() {
//        // Setup
//
//        // Configure SearchChemicalDetailsRepository.findByDtxsidEquals(...).
//        final SearchChemicalDetails searchChemicalDetails = new SearchChemicalDetails();
//        searchChemicalDetails.setSearchMatch("Synonym");
//        searchChemicalDetails.setSearchWord("4, 4'-Dihydroxydiphenylpropane");
//        searchChemicalDetails.setModifiedValue("4, 4' DIHYDROXYDIPHENYLPROPANE");
//        searchChemicalDetails.setRank(15);
//        when(mockSearchChemicalDetailsRepository.findByDtxsidEquals("DTXSID70850182")).thenReturn(searchChemicalDetails);
//
//        // Run the test
//        assertThatThrownBy(() -> tabsServiceUnderTest.validateIframeUrl("DTXSID70805182")).isInstanceOf(IOException.class);
//    }

    @Test
    public void testGetPubchemCid() {

        final SearchChemicalDetails searchChemicalDetails = new SearchChemicalDetails();
        searchChemicalDetails.setSearchMatch("Synonym");
        searchChemicalDetails.setSearchWord("4, 4'-Dihydroxydiphenylpropane");
        searchChemicalDetails.setModifiedValue("4, 4' DIHYDROXYDIPHENYLPROPANE");
        searchChemicalDetails.setRank(15);
        searchChemicalDetails.setDtxsid("DTXSID7080182");
        searchChemicalDetails.setPubchemCid(6623);
        when(mockSearchChemicalDetailsRepository.findByDtxsidEquals("DTXSID7080182")).thenReturn(searchChemicalDetails);


        // Run the test
        final String result = tabsServiceUnderTest.getPubchemCid("DTXSID7080182");

        // Verify the results
        assertThat(result).isEqualTo(String.valueOf("6623"));
    }
}
