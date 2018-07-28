package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Log3 {

    @Pointcut("execution(* com.example.*.*(..))")
    public void joinPointExpression() {

    }

    @Before("joinPointExpression()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before");
    }

    @After("joinPointExpression()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after");
    }

    @AfterReturning(value = "execution(* com.example.*.*(..))", returning = "user")
    public void afterReturning(JoinPoint joinPoint, String user) {
        System.out.println("after returning, user=" + user);
    }

    @AfterThrowing(value = "execution(* com.example.*.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("after throwing, e=" + e.getMessage());
    }

    @Around("joinPointExpression()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("around after");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
    }
}
