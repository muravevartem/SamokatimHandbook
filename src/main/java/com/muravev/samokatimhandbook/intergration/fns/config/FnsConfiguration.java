package com.muravev.samokatimhandbook.intergration.fns.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class FnsConfiguration {

    @Value("${integration.fns.base-url}")
    private final String baseUrl;

    @Value("${integration.fns.token}")
    private final String token;


    @Bean
    RestTemplate fnsClient(RestTemplateBuilder builder) {
        return builder.rootUri(baseUrl)
                .defaultHeader(
                        HttpHeaders.AUTHORIZATION,
                        "Token " + token
                )
                .build();
    }
}
