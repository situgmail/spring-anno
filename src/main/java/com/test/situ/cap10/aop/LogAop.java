package com.test.situ.cap10.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Classname LogAop
 * @Description TODO
 * @Date 2020/6/3 20:17
 * @Created by glsitu
 * @Version 1.0
 */
@Aspect
public class LogAop {

    @Pointcut("execution(public int com.test.situ.cap10.aop.Calculator.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){

    System.out.println(joinPoint.getSignature().getName() + " before......参数={" + Arrays.toString(joinPoint.getArgs()) + "}");
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("end......");
    }

    @AfterReturning("pointCut()")
    public void logReturn(){
        System.out.println("方法执行......");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception){
        System.out.println("报错......" + exception.getMessage());
    }

//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        System.out.println("around before......");
//        Object obj = proceedingJoinPoint.proceed();
//        System.out.println("around end......");
//
//        return obj;
//    }

}
