package com.atguigu.boot;

import com.atguigu.boot.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Bool01Helloworld2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Bool01Helloworld2Application.class, args);
        Person bean = run.getBean(Person.class);
        System.out.println(bean);
    }

}
