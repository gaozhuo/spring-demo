package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Log2 {

    public void before(JoinPoint joinPoint) {
        System.out.println("before");
    }

    public void after(JoinPoint joinPoint) {
        System.out.println("after");
    }

    public void afterReturning(JoinPoint joinPoint, String user) {
        System.out.println("after returning, user=" + user);
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("after throwing, e=" + e.getMessage());
    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
        System.out.println("around after");
    }
}
