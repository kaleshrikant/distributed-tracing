package com.spring.boot.child.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ChildConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
