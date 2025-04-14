package gov.epa.ccte.api.ccdapp1.pgsql.repository.search;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchMassAndFormula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface SearchMassAndFormulaRepository extends JpaRepository<SearchMassAndFormula, String> {

    @Query( value = "select dtxsid, dtxcid, casrn, compound_id, generic_substance_id, preferred_name, active_assays," +
            " cpdata_count, mol_formula, monoisotopic_mass, percent_assays, pubchem_count, pubmed_count, sources_count," +
            " qc_level, qc_level_desc, stereo, isotope, multicomponent, total_assays, toxcast_select, pubchem_cid," +
            " related_substance_count, related_structure_count, has_structure_image, " +
            " iupac_name, smiles, inchi_string, average_mass, inchikey,toxval_data, \n" +
            " case when :mass =0.0 then null else monoisotopic_mass - :mass end as mass_diff\n" +
            " from {h-schema}chemical_details where monoisotopic_mass between :start and :end and dtxsid <> 'DTXSID00000000' " +
            " order by monoisotopic_mass ",
            countQuery = "select count(*) from ccd_app.chemical_details where monoisotopic_mass between :start and :end and dtxsid <> 'DTXSID00000000'",
            nativeQuery = true)
    Page<SearchMassAndFormula> getMassValues(@Param("start") Double start, @Param("end") Double end, @Param("mass") Double mass, Pageable pageable);

    // for SSS project
    @Query( value = "select dtxsid, dtxcid, casrn, compound_id, generic_substance_id, preferred_name, active_assays," +
            " cpdata_count, mol_formula, monoisotopic_mass, percent_assays, pubchem_count, pubmed_count, sources_count," +
            " qc_level, qc_level_desc, stereo, isotope, multicomponent, total_assays, toxcast_select, pubchem_cid," +
            " related_substance_count, related_structure_count, has_structure_image, " +
            " iupac_name, smiles, inchi_string, average_mass, inchikey, toxval_data, \n" +
            " case when :mass =0.0 then null else monoisotopic_mass - :mass end as mass_diff\n" +
            " from {h-schema}chemical_details where monoisotopic_mass between :start and :end and dtxsid <> 'DTXSID00000000' " +
            " order by monoisotopic_mass ",
            nativeQuery = true)
    List<SearchMassAndFormula> getMassValues2(@Param("start") Double start, @Param("end") Double end, @Param("mass") Double mass);

    @Query( value = "select dtxsid, dtxcid, casrn, compound_id, generic_substance_id, preferred_name, active_assays," +
            " cpdata_count, mol_formula, monoisotopic_mass, percent_assays, pubchem_count, pubmed_count, sources_count," +
            " qc_level, qc_level_desc, stereo, isotope, multicomponent, total_assays, toxcast_select, pubchem_cid," +
            " related_substance_count, related_structure_count, has_structure_image, " +
            " iupac_name, smiles, inchi_string, average_mass, inchikey, toxval_data, \n" +
            " case when :mass =0.0 then null else monoisotopic_mass - :mass end as mass_diff\n" +
            " from {h-schema}chemical_details where monoisotopic_mass between :start and :end and dtxsid <> 'DTXSID00000000' " +
            " and toxval_data = :toxval order by monoisotopic_mass ",
            nativeQuery = true)
    List<SearchMassAndFormula> getMassValues3(@Param("start") Double start, @Param("end") Double end, @Param("mass") Double mass, @Param("toxval") String toxval);

    Optional<List<SearchMassAndFormula>> findByMonoisotopicMassBetweenAndDtxsidIsNot(Double start, Double end, String skipDtxsid);

    Long countByMonoisotopicMassBetweenAndDtxsidIsNot(Double start, Double end, String skipDtxsid);

    @Query( value = "select dtxsid, dtxcid, casrn, compound_id, generic_substance_id, preferred_name, active_assays," +
            " cpdata_count, mol_formula, monoisotopic_mass, percent_assays, pubchem_count, pubmed_count, sources_count," +
            " qc_level, qc_level_desc, stereo, isotope, multicomponent, total_assays, toxcast_select, pubchem_cid," +
            " related_substance_count, related_structure_count, has_structure_image, " +
            " iupac_name, smiles, inchi_string, average_mass, inchikey, toxval_data,\n" +
            " null as mass_diff\n" +
            " from {h-schema}chemical_details where mol_formula = :formula and dtxsid <> 'DTXSID00000000' " +
            " order by dtxsid ",
            nativeQuery = true)
    List<SearchMassAndFormula> getExactFormulaResult(@Param("formula") String formula);

    @Query( value = "select dtxsid, dtxcid, casrn, compound_id, generic_substance_id, preferred_name, active_assays," +
            " cpdata_count, mol_formula, monoisotopic_mass, percent_assays, pubchem_count, pubmed_count, sources_count," +
            " qc_level, qc_level_desc, stereo, isotope, multicomponent, total_assays, toxcast_select, pubchem_cid," +
            " related_substance_count, related_structure_count, has_structure_image, " +
            " iupac_name, smiles, inchi_string, average_mass, inchikey, toxval_data,\n" +
            " null as mass_diff\n" +
            " from {h-schema}chemical_details where mol_formula = :formula and dtxsid <> 'DTXSID00000000' " +
            " and toxval_data = :toxval order by dtxsid ",
            nativeQuery = true)
    List<SearchMassAndFormula> getExactFormulaResultWithToxVal(@Param("formula") String formula, @Param("toxval") String toxval);

    @Query( value = "select dtxsid, dtxcid, casrn, compound_id, generic_substance_id, preferred_name, active_assays," +
            " cpdata_count, mol_formula, monoisotopic_mass, percent_assays, pubchem_count, pubmed_count, sources_count," +
            " qc_level, qc_level_desc, stereo, isotope, multicomponent, total_assays, toxcast_select, pubchem_cid," +
            " related_substance_count, related_structure_count, has_structure_image, " +
            " iupac_name, smiles, inchi_string, average_mass, inchikey, toxval_data,\n" +
            " null as mass_diff\n" +
            " from {h-schema}chemical_details where mol_formula in (:formulas) and dtxsid <> 'DTXSID00000000' " +
            " order by dtxsid ",
            nativeQuery = true)
    List<SearchMassAndFormula> getExactFormulaResult(@Param("formulas") List<String> formulas);

    @Query( value = "select dtxsid, dtxcid, casrn, compound_id, generic_substance_id, preferred_name, active_assays," +
            " cpdata_count, mol_formula, monoisotopic_mass, percent_assays, pubchem_count, pubmed_count, sources_count," +
            " qc_level, qc_level_desc, stereo, isotope, multicomponent, total_assays, toxcast_select, pubchem_cid," +
            " related_substance_count, related_structure_count, has_structure_image, " +
            " iupac_name, smiles, inchi_string, average_mass, inchikey, toxval_data,\n" +
            " null as mass_diff\n" +
            " from {h-schema}chemical_details where mol_formula in (:formulas) and dtxsid <> 'DTXSID00000000' " +
            " and toxval_data = :toxval order by dtxsid ",
            nativeQuery = true)
    List<SearchMassAndFormula> getExactFormulaResultWithToxVal(@Param("formulas") List<String> formulas, @Param("toxval") String toxval);

    long countByMolFormulaIsAndDtxsidIsNot(String formula, String dtxsidToAvoid);
}
