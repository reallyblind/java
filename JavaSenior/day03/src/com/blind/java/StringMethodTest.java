package com.blind.java;

import org.junit.Test;

/**
 * @author blind
 * @create 2022-08-22-14:44
 */
public class StringMethodTest {
    @Test
    public void test1(){
        String s1 = "HelloWorld";

        System.out.println(s1.length());//10
        System.out.println(s1.charAt(2));//l

//        s1 = "";
        System.out.println(s1.isEmpty());//false

        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1是不可变的，仍为原来的字符串 HelloWorld
        System.out.println(s2);//改成小写以后的字符串 helloworld

        String s3 = "   he  llo    world    ";
        String s4 = s3.trim();
        System.out.println("-----" + s3 + "-----");//-----   he  llo    world    -----
        System.out.println("-----" + s4 + "-----");//-----he  llo    world-----

    }

    @Test
    public void test2(){
        String s1 = "helloworld";
        String s2 = "HElloWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);//abcdef

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//-2  涉及到字符串排序

        String s7 = "北京山龟骨教育";
        String s8 = s7.substring(2);
        System.out.println(s7);//北京山龟骨教育
        System.out.println(s8);//山龟骨教育

        String s9 = s7.substring(2,5);
        System.out.println(s9);//山龟骨

    }

    @Test
    public void test3(){
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);//true

        boolean b2 =str1.startsWith("He");
        System.out.println(b2);//false

        boolean b3 =str1.startsWith("ll",2);
        System.out.println(b3);//true

        String str2 = "wor";
        System.out.println(str1.contains(str2));//true

        System.out.println(str1.indexOf("lo"));//3
        System.out.println(str1.indexOf("lol"));//-1
        System.out.println(str1.indexOf("lo",5));

        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));//7
        System.out.println(str3.lastIndexOf("or",6));//4

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str。情况二：不存在str

    }
    @Test
    public void test4(){
        String str1 = "北北京尚硅谷教育";
        String str2 = str1.replace('北','东');

        System.out.println(str1);//北北京尚硅谷教育
        System.out.println(str2);//东东京尚硅谷教育

        String str3 = str1.replace("北京", "上海");//北上海尚硅谷教育
        System.out.println(str3);

        System.out.println("**********");

        String str = "12hello34world5java7891mysql456";
        String string = str.replaceAll("\\d+",",").replaceAll("^,|,$","");
        System.out.println(string);//hello,world,java,mysql



    }

}
