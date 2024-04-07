package com.blind.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提升流的读取、写入的速度
 *  提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流：就是”套接“在已有的流的基础上
 *
 *
 *
 *
 * @author blind
 * @create 2022-09-24-16:19
 */
public class BufferedTest {
    /*
    实现非文本文件的复制



     */
    @Test
    public void BufferedStreamTest(){

    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);


            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);

//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if(bis!=null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos!=null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：在关闭外层流的同时，内层流也会自动的进行关闭。对于内层流的关闭，我们可以省略
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\kasssa\\Desktop\\白.mp4";
        String destPath = "C:\\Users\\kasssa\\Desktop\\白2.mp4";

        copyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));//936
    }

    /*
    使用BufferedReader和BufferedWriter实现文本文件

     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和对应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：
//            char[] cbuf = new char[1024];
//            int len ;
//            while((len = br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

            //方式二：
            String data;
            while((data=br.readLine())!=null){
                //方法一
                bw.write(data+"\n");//data中不含换行符

                //方法二：
//                bw.write(data);
//                bw.newLine();//提供换行的操作
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(bw!=null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


}
