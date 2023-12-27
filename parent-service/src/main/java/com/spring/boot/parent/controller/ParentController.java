package com.spring.boot.parent.controller;

import com.spring.boot.parent.service.ParentService;
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
    public String greeting() {
        log.info("Inside greeting() of {} ",ParentController.class);
        log.info("Parent was called ...");
        log.info("Say Hi to Grandchild ...");
        return parentService.greeting();
    }
}
