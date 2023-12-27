package com.spring.boot.parent.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ParentConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
