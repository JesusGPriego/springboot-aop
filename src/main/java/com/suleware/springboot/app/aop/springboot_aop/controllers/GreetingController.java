package com.suleware.springboot.app.aop.springboot_aop.controllers;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suleware.springboot.app.aop.springboot_aop.services.GreetingService;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public ResponseEntity<Object> greeting() {
        return ResponseEntity.ok().body(
                Collections.singletonMap("greeting", greetingService.sayHello("Suleware", "Hola qué tal")));
    }

}
