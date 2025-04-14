package gov.epa.ccte.api.ccdapp1.pgsql.domain.actor;

import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * 
 * @author arashid
 * Create at 2022-03-15 14:56
 */
@Entity
@Table(name = "assay_data_vw")
@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class AssayData {

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
    @Column(name = "concentration")
    private BigDecimal concentration;

    /**
     * 
     */
    @Column(name = "conc_units", length = 45)
    private String concUnits;

    /**
     * 
     */
    @Column(name = "value_numerical")
    private BigDecimal valueNumerical;

    /**
     * 
     */
    @Column(name = "value_string")
    private String valueString;
}
