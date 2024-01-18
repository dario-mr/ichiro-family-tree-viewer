package com.dario.iftv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ApplicationConfig {

    private static final int CONNECTION_TIMEOUT = 5;

    @Bean
    public RestTemplate restTemplate() {
        var httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(Duration.ofSeconds(CONNECTION_TIMEOUT));

        return new RestTemplate(httpRequestFactory);
    }
}
