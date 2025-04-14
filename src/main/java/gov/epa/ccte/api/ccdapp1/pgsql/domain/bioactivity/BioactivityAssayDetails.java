package gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.*;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

/**
 * 
 * @author arashid
 * Create at 2021-01-13 14:47
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Immutable
@Table(name = "vw_bioactivity_assay_list", schema = "ccd_app")
public class BioactivityAssayDetails {

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dtxsid", length = 45)
    private String dtxsid;

    /**
     * 
     */
    @Column(name = "assay_component_endpoint_name")
    private String assayComponentEndpointName;

    /**
     * 
     */
    @Column(name = "name", length = 0)
    private String name;

    /**
     * 
     */
    @Column(name = "description", length = 0)
    private String description;

    /**
     * 
     */
    @Column(name = "hitc", precision = 1)
    private BigDecimal hitc;

    /**
     * 
     */
    @Column(name = "chid_rep", precision = 1)
    private BigDecimal chidRep;

    /**
     * 
     */
    @JsonRawValue
    @Column(name = "gene")
    private String gene;

    /**
     * 
     */
    @Column(name = "intended_target", length = 50)
    private String intendedTarget;

    /**
     * 
     */
    @Column(name = "cell_line")
    private String cellLine;

    /**
     * 
     */
    @Column(name = "cell_format")
    private String cellFormat;

    /**
     * 
     */
    @Column(name = "detection_technology", length = 200)
    private String detectionTechnology;

    /**
     * 
     */
    @Column(name = "m4id")
    private Long m4id;
}
