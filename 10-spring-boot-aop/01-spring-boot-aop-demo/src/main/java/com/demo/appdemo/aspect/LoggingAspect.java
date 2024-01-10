package com.demo.appdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    /*this is where we add all of our related advices for logging*/

    /* @Before("execution(public void com.demo.appdemo.DAO.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======> Executing @Before advice on addAccount() ");
    } */

    //@Before("execution(public void add*())")
    @Before("execution(* com.demo.appdemo.DAO.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======> Executing @Before advice on addAccount() ");
    }
}
