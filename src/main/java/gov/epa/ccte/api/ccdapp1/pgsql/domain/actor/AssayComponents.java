package gov.epa.ccte.api.ccdapp1.pgsql.domain.actor;

import lombok.*;
import jakarta.persistence.*;

/**
 * 
 * @author arashid
 * Create at 2022-03-15 14:56
 */
@Entity
@Table(name = "assay_components_vw")
@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class AssayComponents {

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

    @Column(name = "assay_component_name")
    private String assayComponentName;

    /**
     * 
     */
    @Column(name = "source_id")
    private String sourceId;

    /**
     * 
     */
    @Column(name = "source_name")
    private String sourceName;

    /**
     * 
     */
    @Column(name = "description")
    private String description;

    /**
     * 
     */
    @Column(name = "units")
    private String units;

    /**
     * 
     */
    @Column(name = "value_type")
    private String valueType;

    /**
     * 
     */
    @Column(name = "component_type")
    private String componentType;
}
