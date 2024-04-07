package com.blind.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author blind
 * @create 2022-10-01-14:07
 */
public class URLTest1 {
    public static void main(String[] args){

        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("");//URL地址

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();

            fos = new FileOutputStream("day10\\水3.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(is!=null){

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }if(urlConnection!=null){
                urlConnection.disconnect();
            }
        }




    }
}
