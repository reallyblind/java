package com.atguigu.controller;

import com.atguigu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author blind
 * @create 2023-02-09-20:04
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;



}
