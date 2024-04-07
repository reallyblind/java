package com.example.myfirstxm.config;

/**
 * @author blind
 * @create 2023-02-23-18:53
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.example.myfirstxm.mbg.mapper","com.example.myfirstxm.dao"})
public class MyBatisConfig {
}
