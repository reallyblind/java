package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author blind
 * @create 2023-02-01-15:34
 *
 *
 */

@Component
@Aspect
@Order(20)
public class ValidateAspect {

//    @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
   @Before("com.atguigu.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
       System.out.println("ValidateAspect-->前置通知");
    }



}
