package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author blind
 * @create 2022-11-20-20:35
 */
public class SqlSessionFactoryUtils {

    private  static  SqlSessionFactory sqlSessionFactory;
    static {
        //静态代码块会随着类的加载而自动加载，且只执行一次

           try {
               String resource = "mybatis-config.xml";
               InputStream inputStream  = Resources.getResourceAsStream(resource);
               SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
           } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}
