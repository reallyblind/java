package com.blind.java;

import org.junit.Test;

import java.util.Optional;

/**
 * @author blind
 * @create 2022-10-09-18:35
 */
public class OptionalTest {

    @Test
    public void test1(){

        //empty():创建的Optional对象内部的value是null
        Optional<Object> op1 = Optional.empty();
        if(!op1.isPresent()){
            System.out.println("书记为空");
        }
        System.out.println(op1);
        System.out.println(op1.isPresent());
        //如果Optional封装的数据value为空，则get()报错。否则，value不为空时，返回value
//        System.out.println(op1.get());
    }

    @Test
    public void test2(){
        String str = "Hello";

        //of(T t):封装数据t生成Optional对象。要求t非空，否则报错
        Optional<String> op1 = Optional.of(str);
        //get()通常与of()方法搭配使用，用来获取内部的封装的数据value
        String str1 = op1.get();
        System.out.println(str1);

    }

    @Test
    public void test3(){
        String str = "beijing";
        str = null;
        //ofNullable(T t):封装数据t赋给Optional内部的value。不要求t非空
        Optional<String> op1 = Optional.ofNullable(str);

        //orElse(T t):如果Optional内部的value非空，则返回value值。如果value为空，则返回t
        String str2 = op1.orElse("shanghai");
        System.out.println(str2);

    }

}
