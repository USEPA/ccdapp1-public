package gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class TabDisplayDetail {
    public TabDisplayDetail(String label, String labelDisplay, String category, String subCategory, String url, Boolean disable, String listName) {
        this.label = label;
        this.labelDisplay = labelDisplay;
        this.category = category;
        this.subCategory = subCategory;
        this.url = url;
        this.disable = disable;
        this.listName = listName;
    }

    @JsonProperty("label")
    final private String label;

    @JsonProperty("labelDisplay")
    final private String labelDisplay;

    @JsonProperty("category")
    final private String category;
    //t.sub_category, t.url, cds.disable 
    @JsonProperty("subCategory")
    final private String subCategory;

    @JsonProperty("url")
    private String url;

    @JsonProperty("disable")
    private Boolean disable;

    @JsonProperty("listName")
    final private String listName;

    @JsonProperty("dtxsid")
    private String dtxsid;
}
