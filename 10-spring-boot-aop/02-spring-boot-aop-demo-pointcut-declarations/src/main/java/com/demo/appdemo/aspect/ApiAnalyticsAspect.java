package com.demo.appdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAnalyticsAspect {

    @Before("com.demo.appdemo.aspect.AopExpressions.daoPackageNoGettersSetters()")
    public void apiAnalytics(){
        System.out.println("\n======> Perform API analytics ");
    }

}
