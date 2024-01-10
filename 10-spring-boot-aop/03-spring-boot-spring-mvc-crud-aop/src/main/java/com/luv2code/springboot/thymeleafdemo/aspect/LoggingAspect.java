package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    /* setup logger */
    private Logger logger = Logger.getLogger( getClass().getName() );

    /* setup pointcut declarations */
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){ }
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage(){ }
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){ }

    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    private void forAppFlow(){ }

    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint){
        /* display method we are calling */
        String method = joinPoint.getSignature().toShortString();
        logger.info("in @Before: calling method " + method);

        /* display the arguments to the method */

        /* get the arguments */
        Object[] args = joinPoint.getArgs();

        /* loop through and display args */
        for (Object arg : args){
            logger.info("Arguments: " + arg);
        }
    }

    /* add @AfterReturning advice */
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        /* display method we are returning from */
        String method = joinPoint.getSignature().toShortString();
        logger.info("in @AfterReturning: calling method " + method);

        /* display data returned */
        logger.info("Result: " + result);
    }
}
