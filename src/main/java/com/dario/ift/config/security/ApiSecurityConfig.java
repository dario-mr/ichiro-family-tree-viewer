package com.dario.ift.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${api.key.header}")
    private String apiKeyHeader;

    @Value("${api.key.value}")
    private String apiKeyValue;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // require API key for all requests to /api/**
        ApiKeyAuthFilter filter = new ApiKeyAuthFilter(apiKeyHeader);
        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();
            if (!apiKeyValue.equals(principal)) {
                throw new BadCredentialsException("Missing or invalid API key");
            }
            authentication.setAuthenticated(true);
            return authentication;
        });

        httpSecurity.
                antMatcher("/api/**").
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().addFilter(filter).authorizeRequests().anyRequest().authenticated();

        // enable https on Heroku deployment
        httpSecurity.requiresChannel()
                .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                .requiresSecure();
    }

}
