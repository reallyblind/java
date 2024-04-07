package com.blind.java;

import org.junit.Test;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * jdk 8中日期时间API的测试
 *
 * @author blind
 * @create 2022-08-23-16:37
 */
public class JDK8DateTimeTest {
    @Test
    public void test(){
        Date date1 = new Date(2020,9,8);
        System.out.println(date1);

    }
    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime使用频率高
        2.类似于Calendar
     */
    @Test
    public void test1(){
        //now():获取当前的日期、时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定日期时间没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        System.out.println("***************");

        //getXxx()：获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXxx():设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime2);
        System.out.println(localDateTime);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /*
    Instant的使用
    类似于java.util.Date类
     */
    @Test
    public void test2(){
        //now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 -->Date(long mills)
        Instant instant1 = Instant.ofEpochMilli(1661246873706L);
        System.out.println(instant1);

    }

    /*
    DateTimeformatter:格式化或解析日期、时间
    类似于SimpleDateFormat

     */
    @Test
    public void test3(){
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);//2022-08-23T19:44:23.390503200
        System.out.println(str1);//2022-08-23T19:44:23.3905032

        //解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2022-08-23T17:54:38.3553432");
        System.out.println(parse);//{},ISO resolved to 2022-08-23T17:54:38.355343200

        //方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
            //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDateTime

        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2022/8/23 下午8:06
        //本地化相关的格式。如：ofLocalizedDate(FormatStyle.LONG)
        //FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate


        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2022年8月23日星期二

        //重点：方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2022-12-23 08:12:33

        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);//{MicroOfSecond=0, NanoOfSecond=0, MinuteOfHour=52, HourOfAmPm=3, SecondOfMinute=9, MilliOfSecond=0},ISO resolved to 2019-02-18

    }

}
