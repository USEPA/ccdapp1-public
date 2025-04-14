package gov.epa.ccte.api.ccdapp1.pgsql.domain.comments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Entity
@Setter
@Getter
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "email")
    private String email;

    @Column(name = "body")
    @JsonProperty("comment")
    private String comment;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    @Column(name = "feedback")
    @JsonProperty("feedback")
    private String feedback;

    @Column(name = "admin_name")
    @JsonIgnore
    private String adminName;


    @Column(name = "gs_id")
    private Integer gsId;

    @Column(name = "chem_name")
    @JsonProperty("chemName")
    private String chemName;

    @Column(name = "visible")
    @JsonIgnore
    private Boolean visible;

    @Column(name = "annotation_dtxsid")
    private String annotationDtxsid;

    @Column(name = "annotation_text")
    private String annotationText;

    @Column(name = "annotation_location_url")
    private String annotationLocationUrl;

    @Column(name = "full_url")
    private String fullUrl;

    @Column(name = "annotation_xpath")
    private String annotationXpath;

    @Column(name = "annotation_browser_info")
    private String annotationBrowserInfo;

    @Column(name = "assay_name")
    private String assayName;

    @Column(name = "assay_hit_call")
    private String assayHitCall;

    @Column(name = "jira_id")
    private String jiraId;


    @Column(name = "assay_sample_id")
    private String assaySampleId;

    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();


    @PrePersist
    public void verifyComment(){
        this.visible = false;
        log.debug("verify comment");
        log.debug("email - ", email);
    }
}
