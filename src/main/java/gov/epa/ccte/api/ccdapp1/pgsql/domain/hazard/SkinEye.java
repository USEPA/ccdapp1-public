package gov.epa.ccte.api.ccdapp1.pgsql.domain.hazard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "skin_eye_vw", schema = "ccd_app")
public class SkinEye {


    @Id
    private Integer id;


    @JsonProperty("classification")
    @Column(name = "classification")
    private String classification;


    @JsonProperty("dtxsid")
    @Column(name = "dtxsid")
    private String dtxsid;


    @JsonProperty("endpoint")
    @Column(name = "endpoint")
    private String endpoint;


    @JsonProperty("guideline")
    @Column(name = "guideline")
    private String guideline;


    @JsonProperty("reliability")
    @Column(name = "reliability")
    private String reliability;


    @JsonProperty("resultText")
    @Column(name = "result_text")
    private String resultText;


    @JsonProperty("score")
    @Column(name = "score")
    private String score;


    @JsonProperty("source")
    @Column(name = "source")
    private String source;


    @JsonProperty("species")
    @Column(name = "species")
    private String species;


    @JsonProperty("strain")
    @Column(name = "strain")
    private String strain;


    @JsonProperty("studyType")
    @Column(name = "study_type")
    private String studyType;


    @JsonProperty("year")
    @Column(name = "year")
    private int year;

    @JsonProperty("recordUrl")
    @Column(name = "record_url")
    private String recordUrl;

    @JsonProperty("glp")
    @Column(name = "glp")
    private String glp;

    @JsonProperty("authority")
    @Column(name = "authority")
    private String authority;


}
