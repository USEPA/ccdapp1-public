package gov.epa.ccte.api.ccdapp1.pgsql.domain.actor;

import lombok.*;
import jakarta.persistence.*;

/**
 * 
 * @author arashid
 * Create at 2022-03-15 14:56
 */
@Entity
@Table(name = "assays_vw")
@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Assays {

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
    @Column(name = "assay_id")
    private Integer assayId;

    /**
     * 
     */
    @Column(name = "category_id")
    private Integer categoryId;

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
}
