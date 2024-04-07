package com.atguigu.boot.bean;

import lombok.*;

/**
 * @author blind
 * @create 2023-02-12-16:43
 */

@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;
    private Pet pet;

    public User(String name,Integer age){
        this.name=name;
        this.age=age;
    }


}
