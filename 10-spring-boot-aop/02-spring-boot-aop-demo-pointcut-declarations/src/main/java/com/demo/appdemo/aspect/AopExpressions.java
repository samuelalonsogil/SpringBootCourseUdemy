package com.demo.appdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    /* pointcut for get methods of DAO package */
    @Pointcut("execution(* com.demo.appdemo.DAO.*.get*(..))")
    public void  getter(){}

    /* pointcut for set methods of DAO package */
    @Pointcut("execution(* com.demo.appdemo.DAO.*.set*(..))")
    public void  setter(){}

    /* pointcut for all methods of DAO package */
    @Pointcut("execution(* com.demo.appdemo.DAO.*.*(..))")
    public void  forDAOPackage(){}

    /* pointcut for all methods of DAO package but excludes getter/setter methods */
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void  daoPackageNoGettersSetters(){}

}
