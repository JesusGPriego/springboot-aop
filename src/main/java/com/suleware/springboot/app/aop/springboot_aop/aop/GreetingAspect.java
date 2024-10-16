package com.suleware.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("GreetingServicePointcut.greetingPointcut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String info = String.format("Before: %s; args: %s", method, args);
        logger.info(info);
    }

    @After("GreetingServicePointcut.greetingPointcut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String info = String.format("After: %s; args: %s", method, args);
        logger.info(info);
    }

    @AfterReturning("GreetingServicePointcut.greetingPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String info = String.format("AfterReturning: %s; args: %s", method, args);
        logger.info(info);
    }

    @AfterThrowing("GreetingServicePointcut.greetingPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String info = String.format("AfterThrowing: %s; args: %s", method, args);
        logger.info(info);
    }

    @Around("GreetingServicePointcut.greetingPointcut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        String beforeInfo = String.format("Method: %s() called with params %s", method, args);
        logger.info(beforeInfo);
        Object result = null;
        try {
            result = joinPoint.proceed();
            String afterInfo = String.format("Method: %s() returns %s", method, result);
            logger.info(afterInfo);
        } catch (Throwable e) {
            String errorMessage = String.format("Error calling %s(), cause: %s", method, e.getMessage());
            logger.error(errorMessage);
            throw e;
        }
        return result;
    }

}
