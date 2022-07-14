package com.dario.ift.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocumentationConfig {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ichiro Family Tree")
                        .description("API that returns the family tree of our doggy Ichiro Go Takimisou")
                        .version("1.0")
                );
    }

}
