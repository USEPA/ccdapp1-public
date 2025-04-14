package gov.epa.ccte.api.ccdapp1.web.rest;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.recaptcha.RecaptchaObj;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.recaptcha.RecaptchaResponse;
import gov.epa.ccte.api.ccdapp1.service.RecaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "recaptcha")
@CrossOrigin
public class Recaptcha {

    @Autowired
    private ApplicationContext applicationContext;
    private  final RecaptchaService recaptchaService;

    @Value("${recaptcha.clientSecretV2}")
    private String clientSecretV2;

    @Value("${recaptcha.clientSecretV3}")
    private String clientSecretV3;

    public Recaptcha(RecaptchaService recaptchaService) {
        this.recaptchaService = recaptchaService;
    }

    @PostMapping("/verify-user")
    public RecaptchaResponse verifyUserRecaptcha(@RequestBody RecaptchaObj recaptchaObj){
        try {

            String clientSecret = null;
            if(recaptchaObj.getVersion().equalsIgnoreCase("V2")) {
                 clientSecret = clientSecretV2;
            }
            else if (recaptchaObj.getVersion().equalsIgnoreCase("V3")){
                 clientSecret = clientSecretV3;
            }
            JSONObject jsonObject = recaptchaService.verifyRecaptcha(clientSecret, recaptchaObj.getToken());

            Double score = null;
            if (jsonObject.has("score")) {
                score = jsonObject.getDouble("score");
            } else {
                log.warn("Score field is missing in the reCAPTCHA response");
            }

            String hostname = null;
            if (jsonObject.has("hostname")) {
                hostname = jsonObject.getString("hostname");
            } else {
                log.warn("Hostname field is missing in the reCAPTCHA response");
            }

            Boolean success = null;
            if (jsonObject.has("success")) {
                success = jsonObject.getBoolean("success");
            } else {
                log.warn("Success field is missing in the reCAPTCHA response");
            }

            String challengeTs = null;
            if (jsonObject.has("challenge_ts")) {
                challengeTs = jsonObject.getString("challenge_ts");
            } else {
                log.warn("Challenge timestamp field is missing in the reCAPTCHA response");
            }

            String action = null;
            if (jsonObject.has("action")) {
                action = jsonObject.getString("action");
            } else {
                log.warn("Action field is missing in the reCAPTCHA response");
            }


            RecaptchaResponse response = new RecaptchaResponse(score, hostname, Boolean.TRUE.equals(success), challengeTs, action);
            return response;

        }
        catch (final Exception e) {
            log.error("Some error has occurred while verifying the recaptcha for the user.");
            e.printStackTrace();
            return null;
        }
    }
}
