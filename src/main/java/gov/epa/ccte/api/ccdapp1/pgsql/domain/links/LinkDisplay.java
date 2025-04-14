package gov.epa.ccte.api.ccdapp1.pgsql.domain.links;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class LinkDisplay {

    public LinkDisplay(String iconUrl, String label, String name, String url,  String description, String noResultsResponse, String paramType, String paramValue, String dtxsid) {
        this.iconUrl = iconUrl;
        this.label = label;
        this.name = name;
        this.url = url;
        this.description = description;
        this.noResultsResponse = noResultsResponse;
        this.paramType = paramType;
        this.paramValue = paramValue;
        this.dtxsid = dtxsid;
    }



    @JsonProperty("iconUrl")
    private String iconUrl;


    @JsonProperty("label")
    private String label;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("visible")
    private Boolean visible;


    @JsonProperty("description")
    private String description;

    @JsonProperty("noResultsResponse")
    private String noResultsResponse;


    @JsonProperty("paramType")
    private String paramType;

    @JsonProperty("paramValue")
    private String paramValue;

    @JsonProperty("dtxsid")
    private String dtxsid;

}
