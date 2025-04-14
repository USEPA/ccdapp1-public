package gov.epa.ccte.api.ccdapp1.pgsql.domain.actor;

import lombok.*;
import jakarta.persistence.*;

/**
 * 
 * @author arashid
 * Create at 2022-03-15 14:56
 */
@Entity
@Table(name = "assay_details_vw")
@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class AssayDetails {

    @Id
    private Integer id;

    /**
     * 
     */
    @Column(name = "assay_id")
    private Integer assayId;

    /**
     * 
     */
    @Column(name = "assay_name")
    private String assayName;

    /**
     * 
     */
    @Column(name = "assay_description")
    private String assayDescription;

    /**
     * 
     */
    @Column(name = "assay_code")
    private String assayCode;

    /**
     * 
     */
    @Column(name = "source")
    private String source;

    /**
     * 
     */
    @Column(name = "source_id")
    private String sourceId;

    /**
     * 
     */
    @Column(name = "url")
    private String url;

    /**
     * 
     */
    @Column(name = "data_collection_id")
    private Integer dataCollectionId;

    /**
     * 
     */
    @Column(name = "data_collection")
    private String dataCollection;

    /**
     * 
     */
    @Column(name = "substance_count")
    private Integer substanceCount;

    /**
     * 
     */
    @Column(name = "component_count")
    private Integer componentCount;

    /**
     * 
     */
    @Column(name = "qc_status_id")
    private Integer qcStatusId;

    /**
     * 
     */
    @Column(name = "qc_status", length = 45)
    private String qcStatus;

    /**
     * 
     */
    @Column(name = "species_id")
    private Integer speciesId;

    /**
     * 
     */
    @Column(name = "species")
    private String species;

    /**
     * 
     */
    @Column(name = "phenotype")
    private String phenotype;

    /**
     * 
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 
     */
    @Column(name = "category")
    private String category;
}
