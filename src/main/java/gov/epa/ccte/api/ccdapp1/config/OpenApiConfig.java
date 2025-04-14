package gov.epa.ccte.api.ccdapp1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }


    private Info apiInfo() {
        return new Info()
                .title("ccdapp1")
                .version("1")
                .description("ccdapp1")
                .contact(apiContact());
    }

    private Contact apiContact() {
        return new Contact()
                .name("Asif Rashid, Srikanth Deevi")
                .email("rashid.asif@epa.gov")
                .url("https://confluence.epa.gov/pages/viewpage.action?pageId=64456469");
    }


}

