package gov.epa.ccte.api.ccdapp1.pgsql.domain.recaptcha;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RecaptchaObj {
    private String token;
    private String version;
}
