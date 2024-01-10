package com.demo.appdemo.aspect;

import com.demo.appdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class LoggingAspect {
    /*this is where we add all of our related advices for logging*/

    /* @Before("execution(public void com.demo.appdemo.DAO.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======> Executing @Before advice on addAccount() ");
    } */


    //@Before("execution(public void add*())")
    @Around("execution(* com.demo.appdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        /* print out method we are advising on */
        System.out.println("Executing @Around on method ->" + proceedingJoinPoint.getSignature().toShortString() );

        /* get begin timestamp */
        long begin = System.currentTimeMillis();

        /* now, let's execute the method */
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
        }catch (Exception exception){
            /* log the exception */
            System.out.println(exception.getMessage() );

            /* rethrow exception */
            throw exception;
            //result = "Major accident! But no problem ";
        }

        /* get end timestamp */
        long end = System.currentTimeMillis();

        /* compute duration and display it */
        long duration = end - begin;
        System.out.println("Duration: " + duration/1000.0 + " seconds");

        return result;
    }

    @Before("com.demo.appdemo.aspect.AopExpressions.daoPackageNoGettersSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("\n======> Executing @Before advice on addAccount() ");

        /* display the method signature */
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        /* display method arguments */

        /*get args*/
        Object[] args = joinPoint.getArgs();

        /*loop through args*/
        for (Object arg : args){
            System.out.println("argument: " + arg);

            if (arg instanceof Account){
                /* downcast and print Account specific stuff */
                Account account = (Account) arg;

                System.out.println("account name: " + account.getName());
                System.out.println("account name: " + account.getLevel());
            }
        }
    }


    @After("execution(* com.demo.appdemo.DAO.AccountDAO.findAccounts(..))")
    public void afterFindAccountAdvice(JoinPoint joinPoint){
        System.out.println("Method signature @after finally: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(
            pointcut = "execution(* com.demo.appdemo.DAO.AccountDAO.findAccounts(..))",
            throwing = "throwable")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable throwable){
        /* print oit method  */
        System.out.println("Method signature after throwing: " + joinPoint.getSignature().toShortString() );
        /* log exception  */
        System.out.println("Exception: " + throwable );
    }

    /* add new advice for @AfterReturning on the findAccounts method */
    @AfterReturning(pointcut = "execution(* com.demo.appdemo.DAO.AccountDAO.findAccounts(..))", returning = "accounts")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts){
        /* print out which method we are advising on */
        System.out.println("Executing @AfterReturning on method--> " + joinPoint.getSignature().toShortString());
        /* print out the result of the method call */
        System.out.println("Result is--> " + accounts );
        /* post process the data and modify it */
        /*convert the account names to uppercase*/
        namesToUpperCase(accounts);
        System.out.println("Names uppercase: " + accounts);
    }

    private void namesToUpperCase(List<Account> accounts) {
        for (Account account : accounts){
            account.setName( account.getName().toUpperCase() );
        }
    }
}
