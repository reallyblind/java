package com.atguigu.test;

import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @author blind
 * @create 2023-01-31-20:18
 */
public class ProxyTest {
    /**
     * 动态代理有两种:
     *  1.jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口，
     *  在com.sum.proxy包下，类名为$proxy+数字
     *  2.cglib动态代理,最终生成的代理类会继承目标类，并且和目标类在相同的包下
     *
     *
     *
     *
     */

    @Test
    public void testProxy(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1,2);


    }


}
