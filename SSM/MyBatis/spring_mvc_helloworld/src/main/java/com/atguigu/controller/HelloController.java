package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author blind
 * @create 2023-02-02-16:18
 *
 *
 *
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String portal(){


        //将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){

        return "success";
    }



}
