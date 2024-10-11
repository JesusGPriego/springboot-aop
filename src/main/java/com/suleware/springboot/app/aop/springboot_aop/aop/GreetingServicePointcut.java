package com.suleware.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcut {
    @Pointcut("execution(String com.suleware.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetinFooLoggerPointcut() {
    }

    @Pointcut("execution(String com.suleware.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetinLoggerPointcut() {
    }
}
