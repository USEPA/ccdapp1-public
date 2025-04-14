package gov.epa.ccte.api.ccdapp1.pgsql.domain.recaptcha;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RecaptchaResponse {
    private Double score;
    private String hostname;
    private boolean success;
    private String challenge_ts;
    private String action;
}
