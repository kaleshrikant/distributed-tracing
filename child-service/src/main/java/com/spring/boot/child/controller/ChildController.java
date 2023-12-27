package com.spring.boot.child.controller;

import com.spring.boot.child.service.ChildService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping("/greet")
    @Observed(
            name = "user.name", // <user.name> will be used as a metric name
            contextualName = "Child --> GrandChild", // <Child --> GrandChild> will be used as a span name
            lowCardinalityKeyValues = {"userType", "userType2"} // <userType=userType2> will be set as a tag for both metric & span
    )
    public String greeting() {
        log.info("Inside greeting() of {} ",ChildController.class);
        log.info("Child was called ...");
        log.info("Calling Grandchild now ...");
        return childService.greeting();
    }
}