package gov.epa.ccte.api.ccdapp1.pgsql.domain.hazard;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "genetox_details_vw", schema = "ccd_app")
public class GenetoxicityDetails {

    @Id
    private Integer id;

    @JsonProperty("source")
    @Column(name = "source")
    private String source;

    @JsonProperty("dtxsid")
    @Column(name = "dtxsid")
    private String dtxsid;

    @JsonProperty("assayCategory")
    @Column(name = "assay_category")
    private String assayCategory;

    @JsonProperty("assayType")
    @Column(name = "assay_type")
    private String assayType;

    @JsonProperty("metabolicActivation")
    @Column(name = "metabolic_activation")
    private String metabolicActivation;

    @JsonProperty("species")
    @Column(name = "species")
    private String species;

    @JsonProperty("strain")
    @Column(name = "strain")
    private String strain;

    @JsonProperty("assayResult")
    @Column(name = "assay_result")
    private String assayResult;

    @JsonProperty("year")
    @Column(name = "year")
    private Integer year;

    @Column(name = "rn")
    @JsonProperty("rn")
    private Integer rn;


}
