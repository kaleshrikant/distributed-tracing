package com.spring.boot.child.controller;

import com.spring.boot.child.service.ChildService;
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
    public String greeting() {
        log.info("Inside greeting() of {} ",ChildController.class);
        log.info("Child was called ...");
        log.info("Calling Grandchild now ...");
        return childService.greeting();
    }
}
