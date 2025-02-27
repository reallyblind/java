package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author blind
 * @create 2023-02-11-21:27
 *
 * 主程序类；主配置类
 * @SpringBootApplication：这是一个SpringBoot应用
 *
 */
//@SpringBootApplication  包括以下三个注解
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.atguigu.boot")
public class MainApplication {
    public static void main(String[] args){
        //1.返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3.从容器中获取组件
//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//        System.out.println(tom01==tom02);//true
//
//        //com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$6bbd72da
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        //（pp）从容器中拿出单实例对象
//        //（pp）如果@Configuration(proxyBeanMethods = true)代理对象调用方法，
//        // SpringBoot总会检查这个组件是否在容器中，保持组件单实例
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user==user1);//true
//
//        User user01 = run.getBean("user01", User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//
//        System.out.println("用户的宠物"+(user01.getPet()==tom));//用户的宠物true
//
//        //5.获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("-----------");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        DBHelper bean1 = run.getBean(DBHelper.class);
//        System.out.println(bean1);

        boolean tom = run.containsBean("tom");
        System.out.println("容器中tom组件"+tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件"+user01);


        Car bean = run.getBean(Car.class);
        System.out.println(bean);


    }

}
