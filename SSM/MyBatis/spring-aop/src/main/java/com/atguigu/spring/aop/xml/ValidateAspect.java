package com.atguigu.spring.aop.xml;

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

public class ValidateAspect {

  public void beforeMethod(){
       System.out.println("ValidateAspect-->前置通知");
    }



}
