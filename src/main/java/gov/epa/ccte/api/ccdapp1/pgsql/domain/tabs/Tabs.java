package gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs;


import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.AbstractAuditingEntity;
import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Data
@Table(name = "tabs")
public class Tabs extends AbstractAuditingEntity {


    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "label_key")
    @JsonProperty("label")
    private String label;

    @Column(name = "label_display")
    @JsonProperty("labelDisplay")
    private String labelDisplay;


    @JsonProperty("category")
    @Column(name = "category")
    private String category;

    @Column(name = "sub_category")
    @JsonProperty("subCategory")
    private String subCategory;

    @Column(name = "url")
    @JsonProperty("url")
    private String url;

    @Column(name = "visible")
    @JsonProperty("visible")
    private Boolean visible;


    @Column(name = "display_order")
    @JsonProperty("displayOrder")
    private String displayOrder;

    @Column(name = "list_name")
    @JsonProperty("listName")
    private String listName;

/*    @OneToMany(targetEntity = ChemicalDataStatus.class, cascade = CascadeType.)
    @JoinColumn(name = "label_key", referencedColumnName = "label_key")
    private List<ChemicalDataStatus> chemicalDataStatuses;*/
}
