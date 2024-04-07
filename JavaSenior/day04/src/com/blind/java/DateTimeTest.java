package com.blind.java;

import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * JDk 8之前的日期时间的API测试
 * 1. System类中currentTimeMills();
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calender
 *
 * @author blind
 * @create 2022-08-23-14:32
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作
    1.1 格式化：日期 ---> 字符串
    1.2 解析： 格式化的逆过程，字符串---> 日期

    2.SimpleDateFormat的实例化

     */
    @Test
    public void test() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析： 格式化的逆过程，字符串---> 日期
        String str = "2022/8/23 下午3:12";

        Date date1 = sdf.parse(str);

        System.out.println(date1);
        //**********************************

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);

        //解析
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);
    }

    /*
    练习一：字符串“2020-09-08"转换为Java.sql.Date

    练习二：”三天打鱼两天晒网“  1990-01-01 xxxx-xx-xx 打鱼还是晒网
     */
    @Test
    public void test2() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
        System.out.println(date.getTime());

    }

    /*
    Calendar日历类的使用(抽象类）的使用

     */
    @Test
    public void test3(){
        //1.实例化
        //方式一：创建子类（GregorianCalender）的对象
        //方式二：调用其静态方法getInstance（）
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime   日历类-->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime:Date -->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


    }

}
