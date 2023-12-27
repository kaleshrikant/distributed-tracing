package com.spring.boot.parent.controller;

import com.spring.boot.parent.service.ParentService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping("/greet")
    @Observed(
            name = "user.name", // <user.name> will be used as a metric name
            contextualName = "Parent --> Child", // <Parent --> Child> will be used as a span name
            lowCardinalityKeyValues = {"userType", "userType2"} // <userType=userType2> will be set as a tag for both metric & span
    )
    public String greeting() {
        log.info("Inside greeting() of {} ",ParentController.class);
        log.info("Parent was called ...");
        log.info("Say Hi to Grandchild ...");
        return parentService.greeting();
    }
}