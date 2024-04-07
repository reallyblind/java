package com.itheima.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author blind
 * @create 2022-11-05-11:58
 */

/*
JDBC API详解：Statement
 */
public class JDBCDemo4_Statement {
    /*
    执行DML语句
     */
    @Test
    public void testDML() throws Exception
    {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接:如果连接的是本机mysql并且端口默认是3306，可以简化书写

        String url ="jdbc:mysql:///db1?setting useSSL=false";
        String username = "root";
        String password="abc123";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL语句
        String sql="UPDATE account SET money = 3000 WHERE id = 1";

        //4.获取执行SQL的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行SQL
        int count = stmt.executeUpdate(sql);//执行完DML语句后，受影响的行数

        //6.处理结果
        //System.out.println(count);
        if(count>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        //7.释放资源
        stmt.close();
        conn.close();
    }

    /*
    执行DDL语句
     */
    @Test
    public void testDDL() throws Exception
    {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接:如果连接的是本机mysql并且端口默认是3306，可以简化书写

        String url ="jdbc:mysql:///db1?setting useSSL=false";
        String username = "root";
        String password="abc123";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL语句
        String sql="drop database db2";

        //4.获取执行SQL的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行SQL
        int count = stmt.executeUpdate(sql);//执行完DDL语句后，可能是0

        //6.处理结果
        //System.out.println(count);
//        if(count>0){
//            System.out.println("修改成功");
//        }else{
//            System.out.println("修改失败");
//        }

        System.out.println(count);
        //7.释放资源
        stmt.close();
        conn.close();
    }
}
