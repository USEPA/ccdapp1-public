package gov.epa.ccte.api.ccdapp1.pgsql.domain.actor;

import lombok.*;
import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 * 
 * @author arashid
 * Create at 2022-03-15 14:47
 */
@Entity
@Table(name = "assay_categories_vw")
@Getter
@Setter
@ToString
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class AssayCategories {

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
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 
     */
    @Column(name = "description")
    private String description;

    /**
     * 
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     *
     */
    @Column(name = "level")
    private Integer level;

    /**
     *
     */
    @Column(name = "display_header_number")
    private Integer displayHeaderNumber;

    /**
     *
     */
    @Column(name = "is_visible")
    private Boolean isVisible;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AssayCategories that = (AssayCategories) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
