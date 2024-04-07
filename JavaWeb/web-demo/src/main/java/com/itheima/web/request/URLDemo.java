package com.itheima.web.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author blind
 * @create 2022-11-20-12:43
 */
public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "张三";

        //1.URL编码
        String encode = URLEncoder.encode(username, "UTF-8");
        System.out.println(encode);

        //2.URL解码
//        String decode = URLDecoder.decode(encode, "utf-8");
        String decode = URLDecoder.decode(encode, "iso-8859-1");
        System.out.println(decode);

        //3.转换为字节数据,编码
        byte[] bytes = decode.getBytes("iso-8859-1");
        /*for (byte b : bytes) {
            System.out.print(b+" ");
        }*/

        //4.将字节数组转为字符串，解码
        String s = new String(bytes, "utf-8");
        System.out.println(s);

    }
}
