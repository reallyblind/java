package com.blind.java;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * @author blind
 * @create 2022-08-22-19:17
 */
public class StringBufferBuilderTest {

    /*
    String 、StringBuffer、StringBuilder三者的异同？
    String:不可变的字符序列；底层使用char[]存储
    StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
    StringBuilder:可变的字符序列；线程不安全的，效率高；底层使用char[]存储


    源码分析：
    String str = new String();//new char[0]
    String str1 = new String("abc");//new char[]{'a','b','c'};

    StringBuffer sb1 = new StringBuffer();new char[16]; 底层创建了一个长度为16的数组
    sb1.append('a');//value[0] = 'a';
    sb1.append('b');//value[1] = 'b';

    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length()+16];

    问题一：sout(sb2.length());//3
    问题二：扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
            默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中

    指导意义：开发中建议大家使用：StringBuffer(int capacity)或者StringBuilder(int capacity)

     */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0

    }





    /*


     */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);//abc11

//        s1.delete(2,4);//左闭右开
//        System.out.println(s1);//ab1

//        s1.replace(2,4,"hello");
//        System.out.println(s1);//abhello1

//        s1.insert(2,false);
//        System.out.println(s1);//abfalsec11

        s1.reverse();
        System.out.println(s1);//11cba
    }
}
