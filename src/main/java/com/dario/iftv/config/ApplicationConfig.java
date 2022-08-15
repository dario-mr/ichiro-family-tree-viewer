package com.dario.iftv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    private static final int CONNECTION_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 30000;

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(CONNECTION_TIMEOUT);
        httpRequestFactory.setReadTimeout(READ_TIMEOUT);

        return new RestTemplate(httpRequestFactory);
    }
}
