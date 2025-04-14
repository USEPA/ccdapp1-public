package gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * @author arashid
 * Create at 2021-01-12 09:57
 */
@Entity
@Data
@Table(name = "bioactivity_summary_tab", schema = "ccd_app")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BioactivitySummaryTab {

    @Basic
    @Id
    @Column(name = "m4id")
    Integer m4id;  

    @Column(name = "dtxsid", length = 45)
    private String dtxsid;

    @JsonRawValue
    @Column(name = "gene_info")
    private String geneInfo;

    /**
     *
     */
    @Column(name = "hitcall", precision = 1)
    private BigDecimal hitCall;

    /**
     *
     */
    @Column(name = "top")
    private Double top;

    /**
     *
     */
    @Column(name = "scaled_top")
    private Double scaledTop;

    /**
     *
     */
    @Column(name = "ac50")
    private Double ac50;

    /**
     *
     */
    @Column(name = "logac50")
    private Double logac50;

    /**
     *
     */
    @Column(name = "bmad")
    private Double bmad;

    /**
     *
     */
    @Column(name = "max_med_val")
    private Double maxMedVal;

    /**
     *
     */
    @Column(name = "max_med_conc")
    private Double maxMedConc;

    /**
     *
     */
    @Column(name = "cutoff")
    private Double cutoff;

    /**
     *
     */
    @JsonRawValue
    @Column(name = "flag")
    private String flag;

    @Column(name = "assay_desc_filename")
    private String pdfFileName;


    @Column(name = "seqapass")
    private String SeqAPASS;

    @JsonRawValue
    @Column(name = "event")
    private String event;

    @Column(name = "intended_target_family")
    private String intendedTargetFamily;


    /**
     *
     */
    @Column(name = "stock_concentration")
    private Double stockConcentration;

    /**
     *
     */
    @Column(name = "stock_concentration_units")
    private String stockConcentrationUnits;

    @JsonRawValue
    @Column(name = "aop")

    private String aop;

    @Column(name = "bmd")
    private Double bmd;

    @Column(name = "bmr")
    private Double bmr;

    @JsonRawValue
    @Column(name = "assay_list")
    private String assayList;

    @Basic
    @Column(name = "hitcall_continuous")
    private Double hitcallContinuous;

    @Basic
    @Column(name = "assay_source_name")
    private String assaySourceName;

    @Basic
    @Column(name = "source_description")
    private String sourceDescription;

    @Basic
    @Column(name = "assay_name")
    private String assayName;


    @Basic
    @Column(name = "assay_description")
    private String assayDesc;


    @Basic
    @Column(name = "assay_component_name")
    private String assayComponentName;

    @Basic
    @Column(name = "assay_component_description")
    private String assayComponentDesc;

    @Basic
    @Column(name = "assay_component_endpoint_name")
    private String assayComponentEndpNm;

    @Basic
    @Column(name = "assay_component_endpoint_desc")
    private String assayComponentEndpDesc;

    @Basic
    @Column(name = "assay_function_typ_cd")
    private String assayFunctionType;


    @Basic
    @Column(name = "acc")
    private Double acc;

    @Basic
    @Column(name = "ac10")
    private Double ac10;

    @Basic
    @Column(name = "organism")
    private String organism;

    @Basic
    @Column(name = "cell_short_name")
    private String cellShortName;

    @Basic
    @Column(name = "cell_format")
    private String cellFormat;

    @Basic
    @Column(name = "logc_agg")
    private String logcAgg;

    @Basic
    @Column(name = "resp_agg")
    private String respAgg;

    @Basic
    @Column(name = "cytotox_burst")
    private Double cytotoxBurst;

    @Basic
    @Column(name = "intended_target_type")
    private String intendedTargetType;

    @Basic
    @Column(name = "intended_target_sub_type")
    private String intendedTargetSubType;

    @Basic
    @Column(name = "intended_target_family_sub")
    private String intendedTargetFamSub;

    @Basic
    @Column(name = "biological_process_target")
    private String biologicalProcessTarget;

    @Basic
    @Column(name = "detection_tec_cd")
    private String detectionTechnologyType;


    @Basic
    @Column(name = "tissue")
    private String tissue;

    @Basic
    @Column(name = "chid_rep")
    private String chidRep;

    @Basic
    @Column(name = "sample_id")
    private String sampleId;

    @Basic
    @Column(name = "normalized_data_typ_cd")
    private String normalizedDataTypCd;

}
