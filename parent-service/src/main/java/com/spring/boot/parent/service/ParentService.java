package com.spring.boot.parent.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ParentService {

    // using RestTemplate to call Child
    @Autowired
    private RestTemplate restTemplate;

    public String greeting() {
        log.info("Inside greeting() of ParentService");
        ResponseEntity<String> response = restTemplate
                .exchange(
                        "http://localhost:9002/child-service/greet",
                        HttpMethod.GET,
                        null,
                        String.class
                );
        String responseFromChild = response.getBody();
        return "Grandchild said: " +  responseFromChild;
    }
}
