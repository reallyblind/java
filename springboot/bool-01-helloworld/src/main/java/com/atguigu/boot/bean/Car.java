package com.atguigu.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author blind
 * @create 2023-02-14-12:16
 *
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 *
 */
@Component
@ToString
@Data
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;


}
