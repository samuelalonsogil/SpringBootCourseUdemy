package com.demo.appdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLogAsyncAspect {

    @Before("com.demo.appdemo.aspect.AopExpressions.daoPackageNoGettersSetters()")
    public void logToCloudAsync(){
        System.out.println("\n======> logToCloudAsync ");
    }
}
