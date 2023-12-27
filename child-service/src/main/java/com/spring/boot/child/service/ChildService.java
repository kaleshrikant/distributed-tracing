package com.spring.boot.child.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ChildService {

    // using RestTemplate to call Grand Child
    @Autowired
    private RestTemplate restTemplate;

    public String greeting() {
        log.info("Inside greeting() of ChildService");
        ResponseEntity<String> response = restTemplate
                .exchange(
                        "http://localhost:9003/grandchild-service/greet",
                        HttpMethod.GET,
                        null,
                        String.class
                );
        String responseFromGrandChild = response.getBody();
        return responseFromGrandChild;
    }
}