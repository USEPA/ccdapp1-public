package gov.epa.ccte.api.ccdapp1.pgsql.domain.links;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chemical_link")
public class Links extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    public Links(String iconUrl, String label, String name, String url, String description, String noResultsResponse, String paramType) {
        this.iconUrl = iconUrl;
        this.label = label;
        this.name = name;
        this.url = url;
        this.description = description;
        this.noResultsResponse = noResultsResponse;
        this.paramType = paramType;
    }

    @Column(name = "icon")
    @JsonProperty("iconUrl")
    private String iconUrl;

    @Column(name = "label")
    @JsonProperty("label")
    private String label;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "url")
    @JsonProperty("url")
    private String url;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "no_results_response")
    @JsonProperty("noResultsResponse")
    private String noResultsResponse;

    @Column(name = "param_type")
    @JsonProperty("paramType")
    private String paramType;


}
