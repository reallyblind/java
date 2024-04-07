package com.blind.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author blind
 * @create 2022-08-22-19:58
 */
public class DateTimeTest {
    /*
    java.util.Date类
        |---java.sql.Date类

    1.两个构造器的使用

    2.两个方法的使用
           >toString():显式当前的年月日时分秒
           >getTime()：获取当前Date对象对应的毫秒数（时间戳）
    3.java.sql.Date类对应数据库的日期类型的变量
        >如何实例化
        >sql.Date ---> util.Date对象 直接赋值，多态
         util.Date---> sql.Date对象 用getTime方法

     */
    @Test
    public void test2(){
        //构造器一：Date()
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //构造器二：
        Date date2 = new Date(1661169968387L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1661169968387L);
        System.out.println(date3);

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(64654645164L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二
        Date date6 = new Date();
//        java.sql.Date date7 = (java.sql.Date)date6;//wrong
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }


}
