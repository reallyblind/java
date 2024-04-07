package com.atguigu.spring.test;

import com.atguigu.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author blind
 * @create 2023-01-26-21:14
 */
public class HelloWorldTest {
    @Test
    public void test(){
        //获取IOC容器
        //注:resources和java最终是被加载到同一路径下
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();


    }

}
