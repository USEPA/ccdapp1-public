package gov.epa.ccte.api.ccdapp1.service;

import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@Transactional
public class RecaptchaService {

    public JSONObject verifyRecaptcha(String clientSecret, String token) throws IOException {

        JSONObject jsonObject = null;
        URLConnection connection = null;
        InputStream is = null;
        String charset = StandardCharsets.UTF_8.name();

        String url = "https://www.google.com/recaptcha/api/siteverify";
        try {
            String query = String.format("secret=%s&response=%s",
                    URLEncoder.encode(clientSecret, charset),
                    URLEncoder.encode(token, charset));

            connection = new URL(url + "?" + query).openConnection();

            is = connection.getInputStream();

            String result = IOUtils.toString(is, StandardCharsets.UTF_8);


            jsonObject = new JSONObject(result);

        } catch (IOException | JSONException ex) {
            log.error(ex.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }

            }
        }
        return jsonObject;
    }
}
