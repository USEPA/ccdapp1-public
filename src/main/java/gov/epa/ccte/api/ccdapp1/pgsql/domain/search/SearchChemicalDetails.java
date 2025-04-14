package gov.epa.ccte.api.ccdapp1.pgsql.domain.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.ChemicalDetails;
import lombok.Data;

import jakarta.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Table(name = "chemical_details", schema = "ccd_app")
@SqlResultSetMappings({
        @SqlResultSetMapping( name = "short",
        classes = @ConstructorResult(
                targetClass = ChemicalShortResult.class,
                columns = {
                        @ColumnResult(name="dtxsid"),
                        @ColumnResult(name="dtxcid"),
                        @ColumnResult(name="search_match"),
                        @ColumnResult(name="rank", type = Integer.class),
                        @ColumnResult(name="has_structure_image", type = Boolean.class),
                        @ColumnResult(name="search_word")
                }
        )),
        @SqlResultSetMapping( name = "long",
                classes = @ConstructorResult(
                        targetClass = ChemicalLongResult.class,
                        columns = {
                                @ColumnResult(name="dtxsid"),
                                @ColumnResult(name="dtxcid"),
                                @ColumnResult(name="generic_substance_id", type = Integer.class),
                                @ColumnResult(name="casrn"),
                                @ColumnResult(name="preferred_name"),
                                @ColumnResult(name="compound_id", type = Integer.class),
                                @ColumnResult(name="stereo", type = Integer.class),
                                @ColumnResult(name="isotope", type = Integer.class),
                                @ColumnResult(name="multicomponent", type = Integer.class),
                                @ColumnResult(name="pubchem_count", type = Integer.class),
                                @ColumnResult(name="pubmed_count",type = Integer.class),
                                @ColumnResult(name="sources_count", type = Integer.class),
                                @ColumnResult(name="cpdata_count", type = Long.class),
                                @ColumnResult(name="active_assays", type = Integer.class),
                                @ColumnResult(name="total_assays", type = Integer.class),
                                @ColumnResult(name="percent_assays", type = BigInteger.class),
                                @ColumnResult(name="toxcast_select"),
                                @ColumnResult(name="monoisotopic_mass", type = Double.class),
                                @ColumnResult(name="mol_formula"),
                                @ColumnResult(name="qc_level", type = Integer.class),
                                @ColumnResult(name="qc_level_desc"),
                                @ColumnResult(name="pubchem_cid", type = Integer.class),
                                @ColumnResult(name="has_structure_image", type = Boolean.class),
                                @ColumnResult(name="related_substance_count", type = Integer.class),
                                @ColumnResult(name="related_structure_count", type = Integer.class),
                                @ColumnResult(name="iupac_name"),
                                @ColumnResult(name="smiles"),
                                @ColumnResult(name="inchi_string"),
                                @ColumnResult(name="inchikey"),
                                @ColumnResult(name="average_mass", type = Double.class),
                                @ColumnResult(name="rank", type = Integer.class),
                                @ColumnResult(name="search_match"),
                                @ColumnResult(name="search_word")
                        }
                ))
})

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "SearchChemicalDetails.startWithShortWithoutInchi",
                //resultClass = ChemicalShortResult.class,
                resultSetMapping = "short",
                query = "select dtxsid,dtxcid, search_name as search_match, rank, has_structure_image, search_value as search_word\n" +
                        "from {h-schema}search_chemical where modified_value like :searchWord and search_name not in ('InChIKey', 'Indigo InChIKey') " +
                        "order by rank, search_value asc limit 15"
//                query = "select cd.dtxsid,cd.dtxcid, sc.search_name as search_match, sc.rank, cd.has_structure_image, sc.search_value as search_word \n" +
//                "from ccd_app.chemical_details  cd join ( \n" +
//                "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
//                "from {h-schema}search_chemical where modified_value like :searchWord and search_name not in ('InChIKey', 'Indigo InChIKey') " +
//                "group by dtxsid, dtxcid, search_name, search_value, modified_value,rank )  sc on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid \n" +
//                "order by rank, search_value asc limit 15"

        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.startWithShort",
                resultSetMapping = "short",
                query = "select dtxsid,dtxcid, search_name as search_match, rank, has_structure_image, search_value as search_word\n" +
                        "from {h-schema}search_chemical where modified_value like :searchWord  " +
                        "order by rank, search_value asc limit 15"
//                query = "select cd.dtxsid,cd.dtxcid, sc.search_name as search_match, sc.rank, cd.has_structure_image, sc.search_value as search_word\n" +
//                        "from ccd_app.chemical_details  cd join ( \n" +
//                        "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
//                        "from {h-schema}search_chemical where modified_value like :searchWord  " +
//                        "group by dtxsid, dtxcid, search_name, search_value, modified_value,rank )  sc on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid " +
//                        "order by rank, search_value asc limit 15"

        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.startWithShortWithList",
                resultSetMapping = "short",
                query = " select sc.dtxsid, sc.dtxcid, sc.search_name as search_match, sc.rank, sc.has_structure_image, sc.search_value as search_word\n" +
                        " from {h-schema}search_chemical sc join {h-schema}chemlist_to_subtance sb on sc.dtxsid = sb.dtxsid and sb.list_name = :list \n" +
                        " where sc.modified_value like :searchWord  " +
                        " order by sc.rank, sc.search_value asc limit 15"
//                query = "select cd.dtxsid,cd.dtxcid, sc.search_name as search_match, sc.rank, cd.has_structure_image, sc.search_value as search_word \n" +
//                        "from ccd_app.chemical_details  cd join ( \n" +
//                        "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
//                        "from {h-schema}search_chemical where modified_value like :searchWord " +
//                        "group by dtxsid, dtxcid, search_name, search_value, modified_value,rank)  sc on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid \n" +
//                        "join ccd_app.chemlist_to_subtance sb on sc.dtxsid = sb.dtxsid and sb.list_name = :list \n" +
//                        "order by rank, search_value asc limit 15"

        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.startWithLongWithoutInchi",
                //resultClass = ChemicalShortResult.class,
                resultSetMapping = "long",
                query = "select cd.dtxsid, cd.dtxcid, cd.generic_substance_id, cd.casrn, cd.preferred_name, cd.compound_id, cd.stereo, cd.isotope, " +
                "cd.multicomponent, cd.pubchem_count, cd.pubmed_count, cd.sources_count, cd.cpdata_count, cd.active_assays, cd.total_assays, " +
                "cd.percent_assays, cd.toxcast_select, cd.monoisotopic_mass, cd.mol_formula, cd.qc_level, cd.qc_level_desc, cd.pubchem_cid, " +
                "cd.has_structure_image, cd.related_substance_count, cd.related_structure_count, cd.iupac_name, cd.smiles, cd.inchi_string, " +
                "cd.inchikey, cd.average_mass, sc.rank, sc.search_name as search_match, sc.search_value as search_word \n" +
                "from {h-schema}chemical_details  cd join ( \n" +
                "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
                "from {h-schema}search_chemical where modified_value like :searchWord and search_name not in ('InChIKey', 'Indigo InChIKey')) sc" +
                " on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid \n" +
                "order by rank, search_value asc "

        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.startWithLong",
                resultSetMapping = "long",
                query = "select cd.dtxsid,  cd.dtxcid, cd.generic_substance_id, cd.casrn, cd.preferred_name, cd.compound_id, cd.stereo, cd.isotope, " +
                        "cd.multicomponent, cd.pubchem_count, cd.pubmed_count, cd.sources_count, cd.cpdata_count, cd.active_assays, cd.total_assays, " +
                        "cd.percent_assays, cd.toxcast_select, cd.monoisotopic_mass, cd.mol_formula, cd.qc_level, cd.qc_level_desc, cd.pubchem_cid, " +
                        "cd.has_structure_image, cd.related_substance_count, cd.related_structure_count, cd.iupac_name, cd.smiles, cd.inchi_string, " +
                        "cd.inchikey, cd.average_mass, sc.rank, sc.search_name as search_match, sc.search_value as search_word\n" +
                        "from {h-schema}chemical_details  cd join ( \n" +
                        "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
                        "from {h-schema}search_chemical where modified_value like :searchWord ) sc on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid \n" +
                        "order by rank, search_value asc "
        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.containShort",
                resultSetMapping = "short",
                query = "select dtxsid,dtxcid, search_name as search_match, rank, has_structure_image, search_value as search_word\n" +
                        "from {h-schema}search_chemical where modified_value like :searchWord  " +
                        "order by rank, search_value asc limit 15"
//                query = "select cd.dtxsid,cd.dtxcid, sc.search_name as search_match, sc.rank, cd.has_structure_image, sc.search_value as search_word\n" +
//                        "from ccd_app.chemical_details  cd join ( \n" +
//                        "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
//                        "from {h-schema}search_chemical where modified_value like :searchWord  " +
//                        "group by dtxsid, dtxcid, search_name, search_value, modified_value,rank )  sc on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid \n" +
//                        "order by rank, search_value asc limit 15"

        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.containLong",
                resultSetMapping = "long",
                query = "select cd.dtxsid,  cd.dtxcid, cd.generic_substance_id, cd.casrn, cd.preferred_name, cd.compound_id, cd.stereo, cd.isotope, cd.multicomponent, cd.pubchem_count, cd.pubmed_count, cd.sources_count, cd.cpdata_count, cd.active_assays, cd.total_assays, cd.percent_assays, cd.toxcast_select, cd.monoisotopic_mass, cd.mol_formula, cd.qc_level, cd.qc_level_desc, cd.pubchem_cid, cd.has_structure_image, cd.related_substance_count, cd.related_structure_count, cd.iupac_name, cd.smiles, cd.inchi_string, cd.inchikey, cd.average_mass, sc.rank, sc.search_name as search_match, sc.search_value as search_word\n" +
                        "from ccd_app.chemical_details  cd join (\n" +
                        "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank\n" +
                        "from {h-schema}search_chemical where modified_value like :searchWord )  sc\n" +
                        "    on cd.dtxsid=sc.dtxsid and cd.dtxsid is not null\n" +
                        "union all\n" +
                        "select cd.dtxsid,  cd.dtxcid, cd.generic_substance_id, cd.casrn, cd.preferred_name, cd.compound_id, cd.stereo, cd.isotope, cd.multicomponent, cd.pubchem_count, cd.pubmed_count, cd.sources_count, cd.cpdata_count, cd.active_assays, cd.total_assays, cd.percent_assays, cd.toxcast_select, cd.monoisotopic_mass, cd.mol_formula, cd.qc_level, cd.qc_level_desc, cd.pubchem_cid, cd.has_structure_image, cd.related_substance_count, cd.related_structure_count, cd.iupac_name, cd.smiles, cd.inchi_string, cd.inchikey, cd.average_mass, sc.rank, sc.search_name as search_match, sc.search_value as search_word\n" +
                        "from ccd_app.chemical_details  cd join (\n" +
                        "select  dtxsid, dtxcid, search_name, search_value , modified_value,rank\n" +
                        "from {h-schema}search_chemical where modified_value like :searchWord )  sc\n" +
                        "    on cd.dtxsid is null and cd.dtxcid=sc.dtxcid"
//                query = "select cd.dtxsid,  cd.dtxcid, cd.generic_substance_id, cd.casrn, cd.preferred_name, cd.compound_id, cd.stereo, cd.isotope, " +
//                        "cd.multicomponent, cd.pubchem_count, cd.pubmed_count, cd.sources_count, cd.cpdata_count, cd.active_assays, cd.total_assays, " +
//                        "cd.percent_assays, cd.toxcast_select, cd.monoisotopic_mass, cd.mol_formula, cd.qc_level, cd.qc_level_desc, cd.pubchem_cid, " +
//                        "cd.has_structure_image, cd.related_substance_count, cd.related_structure_count, cd.iupac_name, cd.smiles, cd.inchi_string, " +
//                        "cd.inchikey, cd.average_mass, sc.rank, sc.search_name as search_match, sc.search_value as search_word\n" +
//                        "from {h-schema}chemical_details  cd join ( \n" +
//                        "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
//                        "from ccd_app.search_chemical where modified_value like :searchWord group by " +
//                        "dtxsid, dtxcid, search_name, search_value, modified_value, rank )  sc on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid \n" +
//                        "order by rank, search_value asc "
        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.equalShort",
                resultSetMapping = "short",
                query = "select dtxsid,dtxcid, search_name as search_match, rank, has_structure_image, search_value as search_word\n" +
                        "from {h-schema}search_chemical where modified_value = :searchWord  " +
                        "order by rank, search_value asc limit 15"
//                query = "select cd.dtxsid,cd.dtxcid, sc.search_name as search_match, sc.rank, cd.has_structure_image, sc.search_value as search_word\n" +
//                        "from ccd_app.chemical_details  cd join ( \n" +
//                        "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
//                        "from {h-schema}search_chemical where modified_value = :searchWord  " +
//                        "group by dtxsid, dtxcid, search_name, search_value, modified_value,rank ) sc on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid \n" +
//                        "order by rank, search_value asc limit 15"

        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.equalLong",
                resultSetMapping = "long",
                query = "select cd.dtxsid,  cd.dtxcid, cd.generic_substance_id, cd.casrn, cd.preferred_name, cd.compound_id, cd.stereo, cd.isotope, " +
                        "cd.multicomponent, cd.pubchem_count, cd.pubmed_count, cd.sources_count, cd.cpdata_count, cd.active_assays, cd.total_assays, " +
                        "cd.percent_assays, cd.toxcast_select, cd.monoisotopic_mass, cd.mol_formula, cd.qc_level, cd.qc_level_desc, cd.pubchem_cid, " +
                        "cd.has_structure_image, cd.related_substance_count, cd.related_structure_count, cd.iupac_name, cd.smiles, cd.inchi_string, " +
                        "cd.inchikey, cd.average_mass, sc.rank, sc.search_name as search_match, sc.search_value as search_word\n" +
                        "from {h-schema}chemical_details  cd join ( \n" +
                        "select  dtxsid, dtxcid, search_name, search_value, modified_value,rank \n" +
                        "from ccd_app.search_chemical where modified_value = :searchWord ) sc on cd.dtxsid=sc.dtxsid or cd.dtxcid=sc.dtxcid " +
                        "order by rank, search_value asc "
        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.equalStructureShort",
                resultSetMapping = "short",
                query = "select dtxsid, dtxcid, 'smiles' as search_match, :structure as search_word, 'CC(C)(C1=CC=C(O)C=C1)C1=CC=C(O)C=C1' as modified_value, 5 as rank, has_structure_image\n" +
                        "from {h-schema}chemical_details cd\n" +
                        "where cd.smiles = :structure "
        ),
        @NamedNativeQuery(
                name = "SearchChemicalDetails.equalStructureLong",
                resultSetMapping = "long",
                query = "select dtxsid, dtxcid, 'smiles' as search_match, :structure as search_word, :structure as modified_value, 5 as rank," +
                        " generic_substance_id, casrn, preferred_name, compound_id, stereo, isotope, multicomponent, pubchem_count, pubmed_count, sources_count, " +
                        " cpdata_count, active_assays, total_assays, percent_assays, toxcast_select, monoisotopic_mass, mol_formula, qc_level, qc_level_desc, pubchem_cid, " +
                        " has_structure_image, related_substance_count, related_structure_count, iupac_name, smiles, inchi_string, inchikey, average_mass" +
                        " from {h-schema}chemical_details \n" +
                        " where smiles = :structure "
        )
})

public class SearchChemicalDetails extends ChemicalDetails {

    @JsonProperty("searchMatch")
    private String searchMatch;

    @JsonProperty("searchWord")
    private String searchWord;

    @JsonProperty("modifiedValue")
    private String modifiedValue;

    @JsonProperty("rank")
    private Integer rank;

    @JsonProperty("hasStructureImage")
    private Boolean hasStructureImage;

}
