package com.spring.boot.grandchild.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GrandChildService {

    public String greeting() {
        log.info("Inside greeting() of GrandChildService");
        return "Hi from Grand Child";
    }
}