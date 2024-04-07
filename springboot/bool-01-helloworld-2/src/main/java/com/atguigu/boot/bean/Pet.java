package com.atguigu.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author blind
 * @create 2023-02-15-17:11
 */
@ToString
@Data
@Component
public class Pet {
    private String name;
    private Double weight;
}