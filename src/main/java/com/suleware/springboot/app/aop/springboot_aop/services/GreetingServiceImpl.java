package com.suleware.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String name, String phrase) {
        return phrase + " " + name;
    }

    @Override
    public String sayHelloError(String name, String phrase) {
        throw new RuntimeException("Some error");
    }

}
