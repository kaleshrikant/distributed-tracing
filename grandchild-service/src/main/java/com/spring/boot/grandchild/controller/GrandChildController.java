package com.spring.boot.grandchild.controller;

import com.spring.boot.grandchild.service.GrandChildService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GrandChildController {

    @Autowired
    private GrandChildService grandChildService;

    @GetMapping("/greet")
    @Observed(
            name = "user.name", // <user.name> will be used as a metric name
            contextualName = "GrandChild --> service", // <GrandChild --> service> will be used as a span name
            lowCardinalityKeyValues = {"userType", "userType2"} // <userType=userType2> will be set as a tag for both metric & span
    )
    public String greeting() {
        log.info("Inside greeting() of {} ",GrandChildController.class);
        log.info("Grandchild was called ...");
        return grandChildService.greeting();
    }
}