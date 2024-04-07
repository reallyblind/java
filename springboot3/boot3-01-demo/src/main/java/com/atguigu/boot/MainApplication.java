package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author blind
 * 启动springboot的项目的主入口
 * @create 2024-03-12-15:32
 */
@SpringBootApplication //这是一个Springboot应用
public class MainApplication {
    public static void main(String[] args){
        SpringBootApplication.run(MainApplication.class,args);
    }
}
