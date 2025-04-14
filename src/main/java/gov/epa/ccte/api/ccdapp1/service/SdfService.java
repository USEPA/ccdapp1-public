package gov.epa.ccte.api.ccdapp1.service;

import com.epam.indigo.Indigo;
import com.epam.indigo.IndigoObject;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ChemicalFiles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@SuppressWarnings("unused")
@Service
public class SdfService {

    private Indigo indigo = new Indigo();
    private IndigoObject indigoObject;

    public String convertToSdf(ChemicalFiles sdfFile){
        IndigoObject buf  = indigo.writeBuffer();

        IndigoObject sdf = indigo.loadMolecule(sdfFile.getMolFile());

        sdf.setProperty("DTXSID", sdfFile.getDtxsid());
        sdf.setProperty("PREFERRED_NAME", sdfFile.getPreferredName());
        sdf.setProperty("CASRN", sdfFile.getCasrn());
        sdf.setProperty("INCHIKEY", sdfFile.getInchikey());
        sdf.setProperty("IUPAC_NAME", sdfFile.getIupacName());
        sdf.setProperty("SMILES", sdfFile.getSmiles());
        sdf.setProperty("INCHI_STRING", sdfFile.getInchiString());
        sdf.setProperty("MOLECULAR_FORMULA", sdfFile.getMolFormula());
        sdf.setProperty("AVERAGE_MASS", sdfFile.getAverageMass().toString());
        sdf.setProperty("MONOISOTOPIC_MASS", sdfFile.getMonoisotopicMass().toString());
        sdf.setProperty("DATA_SOURCES", sdfFile.getSourcesCount().toString());
        sdf.setProperty("NUMBER_OF_PUBMED_ARTICLES", sdfFile.getPubmedCount().toString());
        sdf.setProperty("PUBCHEM_DATA_SOURCES", sdfFile.getPubchemCount().toString());
        sdf.setProperty("CPDAT_COUNT", sdfFile.getCpdataCount().toString());

        buf.sdfAppend(sdf);

        return buf.toString();
    }
}
