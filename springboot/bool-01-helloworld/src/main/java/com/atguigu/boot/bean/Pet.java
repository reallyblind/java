package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author blind
 * @create 2023-02-12-16:43
 */
@Data
@ToString
@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
public class Pet {
    private String name;

}
