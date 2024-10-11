package com.suleware.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.suleware.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String info = String.format("Antes: %s; args: %s", method, args);
        logger.info(info);
    }

}
