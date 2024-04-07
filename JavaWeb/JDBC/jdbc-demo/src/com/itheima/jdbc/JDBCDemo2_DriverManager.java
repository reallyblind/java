package com.itheima.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author blind
 * @create 2022-11-05-11:58
 */

/*
JDBC API详解：DriveManager
 */
public class JDBCDemo2_DriverManager {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接:如果连接的是本机mysql并且端口默认是3306，可以简化书写

        String url ="jdbc:mysql:///db1?setting useSSL=false";
        String username = "root";
        String password="abc123";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL语句
        String sql="UPDATE account SET money = 2000 WHERE id = 1;";

        //4.获取执行SQL的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行SQL
        int count = stmt.executeUpdate(sql);//受影响的行数

        //6.处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();

    }

}
