package com.itheima.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author blind
 * @create 2022-11-05-11:58
 */

/*
JDBC API详解：Connection
 */
public class JDBCDemo3_Connection {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接:如果连接的是本机mysql并且端口默认是3306，可以简化书写

        String url ="jdbc:mysql:///db1?setting useSSL=false";
        String username = "root";
        String password="abc123";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL语句
        String sql1="UPDATE account SET money = 3000 WHERE id = 1;";

        String sql2 =  "UPDATE account SET money = 1000 WHERE id = 2";
        //4.获取执行SQL的对象 Statement
        Statement stmt = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);

            //5.执行SQL
            int count1 = stmt.executeUpdate(sql1);//受影响的行数
            //6.处理结果
            System.out.println(count1);

            int i = 3 / 0;

            //5.执行SQL
            int count2 = stmt.executeUpdate(sql2);//受影响的行数
            //6.处理结果
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            e.printStackTrace();
        }


        //7.释放资源
        stmt.close();
        conn.close();
        
    }

}
