package com.itheima.jdbc;


import com.itheima.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blind
 * @create 2022-11-05-11:58
 */

/*
JDBC API详解：ResultSet
 */
public class JDBCDemo6_UserLogin {


    @Test
    public void testLogin() throws Exception
    {

        //2.获取连接:如果连接的是本机mysql并且端口默认是3306，可以简化书写

        String url ="jdbc:mysql:///db1?setting useSSL=false";
        String username = "root";
        String password="abc123";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";

        //获取stmt对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

    /*
    演示SQL注入
     */
    @Test
    public void testLogin_ingect() throws Exception
    {

        //2.获取连接:如果连接的是本机mysql并且端口默认是3306，可以简化书写

        String url ="jdbc:mysql:///db1?setting useSSL=false";
        String username = "root";
        String password="abc123";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "dsadasd";
        String pwd = "'or '1' ='1";

        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";
        System.out.println(sql);
        //获取stmt对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


}
