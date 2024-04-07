package com.blind.java;


import org.junit.Test;

/**
 * @author blind
 * @create 2022-08-23-14:03
 */
public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛出异常
        System.out.println(sb1);
    }

}
