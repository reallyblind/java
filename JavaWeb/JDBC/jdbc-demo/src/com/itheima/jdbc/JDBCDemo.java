package com.itheima.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author blind
 * @create 2022-11-05-11:58
 */

/*
JDBC快速入门


 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url ="jdbc:mysql://127.0.0.1:3306/db1";
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
