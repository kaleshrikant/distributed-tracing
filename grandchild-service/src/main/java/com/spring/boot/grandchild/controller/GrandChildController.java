package com.spring.boot.grandchild.controller;

import com.spring.boot.grandchild.service.GrandChildService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GrandChildController {

    @Autowired
    private GrandChildService grandChildService;

    @GetMapping("/greet")
    public String greeting() {
        log.info("Inside greeting() of {} ",GrandChildController.class);
        log.info("Grandchild was called ...");
        return grandChildService.greeting();
    }



}
