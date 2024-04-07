package com.blind.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 * 客户端。并关闭相应的连接。
 *
 * @author blind
 * @create 2022-10-01-10:22
 */
public class TCPTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        try {
            //1.
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            //2.
            os = socket.getOutputStream();
            //3.
            fis = new FileInputStream(new File("水.jpg"));
            //4.
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();

            //5.接受来自于服务器端的数据，并显示到显示屏上
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bufferr = new byte[20];
            int len1;
            while((len1 = is.read(bufferr))!=-1){
                baos.write(bufferr,0,len1);
            }
            System.out.println(baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(9090);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("水2.jpg"));

        //5.
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        System.out.println("图片传输完成");

        //6.服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，收到，好看".getBytes());

        //6.
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }



}
