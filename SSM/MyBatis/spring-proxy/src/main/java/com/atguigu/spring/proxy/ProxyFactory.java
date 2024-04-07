package com.atguigu.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author blind
 * @create 2023-01-31-19:18
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        /*
        *4中类加载器：引导类>扩展类>系统（应用）类>自定义类加载器
        * ClassLoader loader:指定加载动态生成的代理类的类加载器
        * Class<?>[] interfaces:获取目标对象实现的所有接口的class对象的数组
        * InvocationHandler h:设置代理对象实现目标对象方法的过程，
        * 即代理类中如何重写接口中的抽象方法
        *
        */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("日志，方法："+method.getName()+",参数"+ Arrays.toString(args));
                    //proxy表示代理对象，method表示要执行的方法，args表示要执行的方法的参数列表
                    result = method.invoke(target, args);
                    System.out.println("日志，方法："+method.getName()+",结果"+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("日志，方法："+method.getName()+",异常"+ e);
                } finally {
                    System.out.println("日志，方法："+method.getName()+"方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,h);

    }



}
