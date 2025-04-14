package gov.epa.ccte.api.ccdapp1.pgsql.domain.actor;

import lombok.*;
import jakarta.persistence.*;

/**
 * 
 * @author arashid
 * Create at 2022-03-15 14:56
 */
@Entity
@Table(name = "assay_data_columns_vw")
@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class AssayDataColumns {

    @Id
    private Integer id;

    /**
     * 
     */
    @Column(name = "dtxsid")
    private String dtxsid;

    /**
     * 
     */
    @Column(name = "tab_name")
    private String tabName;

    /**
     * 
     */
    @Column(name = "assay_id")
    private Integer assayId;

    /**
     *
     */
    @Column(name = "assay_category_id")
    private Integer categoryId;

    /**
     * 
     */
    @Column(name = "component_id")
    private Integer componentId;

    /**
     *
     */
    @Column(name = "component_name")
    private String componentName;

    /**
     * 
     */
    @Column(name = "tool_tip")
    private String toolTip;

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
