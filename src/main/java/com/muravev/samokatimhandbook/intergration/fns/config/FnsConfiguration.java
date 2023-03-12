package com.muravev.samokatimhandbook.intergration.fns.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FnsConfiguration {

    @Value("${integration.fns.base-url}")
    private String baseUrl;

    @Value("${integration.fns.token}")
    private String token;;

}
