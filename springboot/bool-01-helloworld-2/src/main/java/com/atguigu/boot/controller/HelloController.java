package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blind
 * @create 2023-02-15-19:38
 */
@RestController
public class HelloController {
   @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person(){
        return person;
    }

}
