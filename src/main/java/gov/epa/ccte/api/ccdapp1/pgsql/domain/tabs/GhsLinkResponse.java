package gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GhsLinkResponse {
    String dtxsid;
    Boolean isSafetyData;
    String safetyUrl;

    public GhsLinkResponse(String dtxsid, Boolean isSafetyData, String safetyUrl) {
        this.dtxsid = dtxsid;
        this.isSafetyData = isSafetyData;
        this.safetyUrl = safetyUrl;
    }
}
