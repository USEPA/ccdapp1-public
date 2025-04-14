package gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

import jakarta.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "bioactivity", schema = "ccd_app")
public class Bioactivity {

    @Id
    @Basic
    @Column(name = "m4id", nullable = true)
    private Long id;

    @Basic
    @Column(name = "num", nullable = true)
    private int num;

    @Basic
    @Column(name = "m4id", nullable = true, insertable = false, updatable = false)
    private Long m4Id;

    @Basic
    @Column(name = "aeid", nullable = true)
    private Long aeid;

    @Basic
    @Column(name = "sample_id", nullable = true, length = 50)
    private String sampleId;

    @Basic
    @Column(name = "mc4_bmad", nullable = true, precision = 0)
    private Double mc4Bmad;

    @JsonRawValue
    @Column(name = "gene_info")
    private String geneInfo;

    @Basic
    @Column(name = "mc4_resp_max", nullable = true, precision = 0)
    private Double mc4RespMax;

    @Basic
    @Column(name = "resp_min", nullable = true, precision = 0)
    private Double respMin;

    @Basic
    @Column(name = "max_mean_val", nullable = true, precision = 0)
    private Double maxMeanVal;

    @Basic
    @Column(name = "max_mean_conc", nullable = true, precision = 0)
    private Double maxMeanConc;

    @Basic
    @Column(name = "max_med_val", nullable = true, precision = 0)
    private Double maxMedVal;

    @Basic
    @Column(name = "max_med_conc", nullable = true, precision = 0)
    private Double maxMedConc;

    @Basic
    @Column(name = "logc_max", nullable = true, precision = 0)
    private Double logcMax;

    @Basic
    @Column(name = "logc_min", nullable = true, precision = 0)
    private Double logcMin;

//    @Basic
//    @Column(name = "cnst_flag", nullable = true)
//    private Boolean cnstFlag;

//    @Basic
//    @Column(name = "hill_flag", nullable = true)
//    private Boolean hillFlag;

//    @Basic
//    @Column(name = "hcov_flag", nullable = true)
//    private Boolean hcovFlag;

//    @Basic
//    @Column(name = "gnls_flag", nullable = true)
//    private Boolean gnlsFlag;

//    @Basic
//    @Column(name = "gcov_flag", nullable = true)
//    private Boolean gcovFlag;

//    @Basic
//    @Column(name = "mc4_cnst_error", nullable = true, precision = 0)
//    private Double mc4CnstError;
//
//    @Basic
//    @Column(name = "mc4_cnst_aic", nullable = true, precision = 0)
//    private Double mc4CnstAic;

//    @Basic
//    @Column(name = "cnst_rmse", nullable = true, precision = 0)
//    private Double cnstRmse;

//    @Basic
//    @Column(name = "cnst_prob", nullable = true, precision = 0)
//    private Double cnstProb;

//    @Basic
//    @Column(name = "hill_tp", nullable = true, precision = 0)
//    private Double hillTp;
//
//    @Basic
//    @Column(name = "hill_tp_sd", nullable = true, precision = 0)
//    private Double hillTpSd;
//
//    @Basic
//    @Column(name = "hill_ga", nullable = true, precision = 0)
//    private Double hillGa;
//
//    @Basic
//    @Column(name = "hill_ga_sd", nullable = true, precision = 0)
//    private Double hillGaSd;

//    @Basic
//    @Column(name = "hill_gw", nullable = true, precision = 0)
//    private Double hillGw;

//    @Basic
//    @Column(name = "hill_gw_sd", nullable = true, precision = 0)
//    private Double hillGwSd;

//    @Basic
//    @Column(name = "hill_er", nullable = true, precision = 0)
//    private Double hillEr;

//    @Basic
//    @Column(name = "hill_er_sd", nullable = true, precision = 0)
//    private Double hillErSd;
//
//    @Basic
//    @Column(name = "hill_aic", nullable = true, precision = 0)
//    private Double hillAic;

//    @Basic
//    @Column(name = "hill_rmse", nullable = true, precision = 0)
//    private Double hillRmse;

//    @Basic
//    @Column(name = "hill_prob", nullable = true, precision = 0)
//    private Double hillProb;

//    @Basic
//    @Column(name = "gnls_tp", nullable = true, precision = 0)
//    private Double gnlsTp;

//    @Basic
//    @Column(name = "gnls_tp_sd", nullable = true, precision = 0)
//    private Double gnlsTpSd;
//
//    @Basic
//    @Column(name = "gnls_ga", nullable = true, precision = 0)
//    private Double gnlsGa;
//
//    @Basic
//    @Column(name = "gnls_ga_sd", nullable = true, precision = 0)
//    private Double gnlsGaSd;

//    @Basic
//    @Column(name = "gnls_gw", nullable = true, precision = 0)
//    private Double gnlsGw;

//    @Basic
//    @Column(name = "gnls_gw_sd", nullable = true, precision = 0)
//    private Double gnlsGwSd;

//    @Basic
//    @Column(name = "gnls_er", nullable = true, precision = 0)
//    private Double gnlsEr;

//    @Basic
//    @Column(name = "gnls_er_sd", nullable = true, precision = 0)
//    private Double gnlsErSd;

//    @Basic
//    @Column(name = "gnls_aic", nullable = true, precision = 0)
//    private Double gnlsAic;

//    @Basic
//    @Column(name = "gnls_rmse", nullable = true, precision = 0)
//    private Double gnlsRmse;

//    @Basic
//    @Column(name = "gnls_prob", nullable = true, precision = 0)
//    private Double gnlsProb;

    @Basic
    @Column(name = "nconc", nullable = true, precision = 0)
    private Integer nconc;

    @Basic
    @Column(name = "npts", nullable = true, precision = 0)
    private Integer npts;

    @Basic
    @Column(name = "nrep", nullable = true, precision = 0)
    private Double nrep;

    @Basic
    @Column(name = "nmed_gtbl", nullable = true, precision = 0)
    private Integer nmedGtbl;

    @Basic
    @Column(name = "tmpi", nullable = true, precision = 0)
    private Integer tmpi;

    @Basic
    @Column(name = "mc4_mthd_id", nullable = true, precision = 0)
    private Integer mc4MthdId;

    @Basic
    @Column(name = "exec_ordr", nullable = true, precision = 0)
    private Integer execOrdr;

    @Basic
    @Column(name = "mc4_method", nullable = true, length = 50)
    private String mc4Mthd;

    @Basic
    @Column(name = "mc4_method_description", nullable = true, length = 255)
    private String mc4MethodDescription;

    @Basic
    @Column(name = "total_chemical_cnt", nullable = true)
    private Integer totalChemicalCnt;

    @Basic
    @Column(name = "active_chemical_cnt", nullable = true)
    private Integer activeChemicalCnt;

    @Basic
    @Column(name = "mc4_chid", nullable = true)
    private Integer mc4Chid;

    @Basic
    @Column(name = "dtxsid", nullable = true, length = 45)
    private String dtxsid;

    @Basic
    @Column(name = "logc_agg", nullable = true)
    private String logcAgg;

    @Basic
    @Column(name = "resp_agg", nullable = true)
    private String respAgg;

    @Basic
    @Column(name = "modl", nullable = true)
    private String modl;

    @Basic
    @Column(name = "model_type", nullable = true,  precision = 0 )
    private Integer modelType;

    @Basic
    @Column(name = "hitcall", nullable = true, precision = 0)
    private Double hitcall;

    @Basic
    @Column(name = "coff", nullable = true, precision = 0)
    private Double coff;

    @Basic
    @Column(name = "actp", nullable = true, precision = 0)
    private Double actp;

    @Basic
    @Column(name = "fitc", nullable = true, precision = 0)
    private Integer fitc;

    @Basic
    @Column(name = "parent_fitc", nullable = true, precision = 0)
    private Integer parentFitc;

    @Basic
    @Column(name = "fit_catg_name", nullable = true, length = 30)
    private String fitCatgName;

    @Basic
    @Column(name = "xloc", nullable = true, precision = 0)
    private Double xloc;

    @Basic
    @Column(name = "yloc", nullable = true, precision = 0)
    private Double yloc;

    @Basic
    @Column(name = "assay_component_endp_nm", nullable = true, length = 255)
    private String assayComponentEndpNm;

    @Basic
    @Column(name = "export_ready_ind", nullable = true, precision = 0)
    private BigInteger exportReadyInd;

    @Basic
    @Column(name = "internal_ready_ind", nullable = true, precision = 0)
    private BigInteger internalReadyInd;

    @Basic
    @Column(name = "assay_component_endp_desc", nullable = true)
    private String assayComponentEndpDesc;

    @Basic
    @Column(name = "assay_function_typ_cd", nullable = true, length = 50)
    private String assayFunctionTypCd;

    @Basic
    @Column(name = "normalized_data_typ_cd", nullable = true, length = 50)
    private String normalizedDataTypCd;

//    @Basic
//    @Column(name = "analysis_direction_cd", nullable = true, length = 20)
//    private String analysisDirectionCd;

    @Basic
    @Column(name = "burst_assay_ind", nullable = true, precision = 0)
    private BigInteger burstAssayInd;

    @Basic
    @Column(name = "positive_control_key", nullable = true, length = 100)
    private String positiveControlKey;

    @Basic
    @Column(name = "signal_direction_cd", nullable = true, length = 20)
    private String signalDirectionCd;

    @Basic
    @Column(name = "intended_tgt_typ_cd", nullable = true, length = 50)
    private String intendedTgtTypCd;

    @Basic
    @Column(name = "intended_tgt_sub_typ_cd", nullable = true, length = 100)
    private String intendedTgtSubTypCd;

    @Basic
    @Column(name = "intended_tgt_fam_tx", nullable = true, length = 50)
    private String intendedTgtFamTx;

    @Basic
    @Column(name = "intended_tgt_fam_sub_tx", nullable = true, length = 50)
    private String intendedTgtFamSubTx;

    @Basic
    @Column(name = "fit_all_ind", nullable = true, precision = 0)
    private BigInteger fitAllInd;

    @Basic
    @Column(name = "cell_viability_assay_ind", nullable = true, precision = 0)
    private BigInteger cellViabilityAssayInd;

    @Basic
    @Column(name = "data_usability_ind", nullable = true, precision = 0)
    private BigInteger dataUsabilityInd;

    @Basic
    @Column(name = "assay_ttl", nullable = true, length = 1024)
    private String assayTtl;

    @Basic
    @Column(name = "biological_response_tx", nullable = true)
    private String biologicalResponseTx;

    @Basic
    @Column(name = "analytical_desc", nullable = true)
    private String analyticalDesc;

    @Basic
    @Column(name = "intended_target_src", nullable = true)
    private String intendedTargetSrc;

    @Basic
    @Column(name = "source_tgt_id", nullable = true)
    private Integer sourceTgtId;

    @Basic
    @Column(name = "m5id", nullable = true)
    private Long m5Id;

    @Basic
    @Column(name = "mc5_chid_rep", nullable = true, precision = 0)
    private BigInteger mc5ChidRep;

    @Basic
    @Column(name = "mc5_coff", nullable = true, precision = 0)
    private Double mc5Coff;

    @Basic
    @Column(name = "mc5_fitc", nullable = true, precision = 0)
    private Integer mc5Fitc;

    @Basic
    @Column(name = "mc5_modl", nullable = true, length = 5)
    private String mc5Modl;

    @Basic
    @Column(name = "mc5_actp", nullable = true, precision = 0)
    private Double mc5Actp;

//    @Basic
//    @Column(name = "mc5_modl_error", nullable = true, precision = 0)
//    private Double mc5ModlError;

//    @Basic
//    @Column(name = "mc5_modl_tp", nullable = true, precision = 0)
//    private Double mc5ModlTp;
//
//    @Basic
//    @Column(name = "mc5_modl_ga", nullable = true, precision = 0)
//    private Double mc5ModlGa;
//
//    @Basic
//    @Column(name = "mc5_modl_gw", nullable = true, precision = 0)
//    private Double mc5ModlGw;
//
//    @Basic
//    @Column(name = "mc5_modl_la", nullable = true, precision = 0)
//    private Double mc5ModlLa;
//
//    @Basic
//    @Column(name = "mc5_modl_lw", nullable = true, precision = 0)
//    private Double mc5ModlLw;

//    @Basic
//    @Column(name = "mc5_modl_prob", nullable = true, precision = 0)
//    private Double mc5ModlProb;

//    @Basic
//    @Column(name = "mc5_modl_rmse", nullable = true, precision = 0)
//    private Double mc5ModlRmse;

//    @Basic
//    @Column(name = "mc5_mdl_acc", nullable = true, precision = 0)
//    private Double mc5ModlAcc;

//    @Basic
//    @Column(name = "mc5_modl_acb", nullable = true, precision = 0)
//    private Double mc5ModlAcb;

//    @Basic
//    @Column(name = "mc5_modl_ac10", nullable = true, precision = 0)
//    private Double mc5ModlAc10;

    @Basic
    @Column(name = "assay_name", nullable = true, length = 255)
    private String assayName;

    @Basic
    @Column(name = "assay_component_name", nullable = true, length = 255)
    private String assayComponentName;

    @Basic
    @Column(name = "ext_uniprot_accesn_num", nullable = true, length = 32)
    private String extUniprotAccesnNum;

//    @Basic
//    @Column(name = "gene_symbol", nullable = true, length = 255)
//    private String geneSymbol;

//    @Basic
//    @Column(name = "official_sym", nullable = true, length = 255)
//    private String officialSym;

//    @Basic
//    @Column(name = "taxon_nm", nullable = true, length = 250)
//    private String taxonNm;

//    @Basic
//    @Column(name = "gene_description", nullable = true, length = 255)
//    private String geneDescription;
//
//    @Basic
//    @Column(name = "gene_name", nullable = true, length = 255)
//    private String geneName;

//    @Basic
//    @Column(name = "official_full_nm", nullable = true, length = 255)
//    private String officialFullNm;

//    @Basic
//    @Column(name = "common_name", nullable = true, length = 250)
//    private String commonNm;

    @Basic
    @Column(name = "source", nullable = true, length = 255)
    private String source;

    @Basic
    @Column(name = "source_description", nullable = true, length = 1024)
    private String sourceDescription;

    @Basic
    @Column(name = "source_long_description", nullable = true)
    private String sourceLongDescription;

    @Basic
    @Column(name = "source_long_name", nullable = true, length = 255)
    private String sourceLongName;

    @Basic
    @Column(name = "assay_format_type", nullable = true, length = 255)
    private String assayFormatType;

    @Basic
    @Column(name = "biological_process_target", nullable = true, length = 255)
    private String biologicalProcessTarget;

    @Basic
    @Column(name = "detection_tec_cd", nullable = true, length = 255)
    private String detectionTechnologyType;

//    @Basic
//    @Column(name = "entrez_gene_id", nullable = true)
//    private Integer entrezGeneId;

//    @Basic
//    @Column(name = "organism_name", nullable = true, length = 255)
//    private String organismName;

    @Basic
    @Column(name = "stkc", nullable = true, length = 255)
    private Double stkc;

    @Basic
    @Column(name = "tissue", nullable = true, length = 255)
    private String tissue;

//    @Basic
//    @Column(name = "gnls_la", nullable = true, precision = 0)
//    private Double gnlsLa;
//
//    @Basic
//    @Column(name = "gnls_la_sd", nullable = true, precision = 0)
//    private Double gnlsLaSd;

//    @Basic
//    @Column(name = "gnls_lw", nullable = true, precision = 0)
//    private Double gnlsLw;

//    @Basic
//    @Column(name = "gnls_lw_sd", nullable = true, precision = 0)
//    private Double gnlsLwSd;

    @JsonRawValue
    @Column(name = "pval_agg")
    private String pval;

    @Basic
    @Column(name = "mc6_flag_agg")
    private String flag;

    @Basic
    @Column(name = "bval_agg")
    private String bval;

    @Basic
    @Column(name = "assay_description")
    private String assayDescription;

    @Basic
    @Column(name = "hitcall_continuous")
    private Double hitcallContinuous;

    @JsonRawValue
    @Column(name = "mc4_param_all")
    private String mc4ParamAll;

    @JsonRawValue
    @Column(name = "mc4_param_cnst")
    private String mc4ParamCnst;

    @JsonRawValue
    @Column(name = "mc4_param_exp2")
    private String mc4ParamExp2;

    @JsonRawValue
    @Column(name = "mc4_param_exp3")
    private String mc4ParamExp3;

    @JsonRawValue
    @Column(name = "mc4_param_exp4")
    private String mc4ParamExp4;

    @JsonRawValue
    @Column(name = "mc4_param_exp5")
    private String mc4ParamExp5;


    @JsonRawValue
    @Column(name = "mc4_param_gnls")
    private String mc4ParamGnls;

    @JsonRawValue
    @Column(name = "mc4_param_hill")
    private String mc4ParamHill;

    @JsonRawValue
    @Column(name = "mc4_param_poly2")
    private String mc4ParamPoly2;

    @JsonRawValue
    @Column(name = "mc4_param_poly1")
    private String mc4ParamPoly1;

    @JsonRawValue
    @Column(name = "mc4_param_pow")
    private String mc4ParamPow;

    @JsonRawValue
    @Column(name = "mc5_param")
    private String mc5Param;

    @JsonRawValue
    @Column(name = "assay_list")
    private String assayList;
}
