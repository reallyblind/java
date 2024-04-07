package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author blind
 * @create 2023-02-04-18:46
 */
@Controller
public class TestViewController {

    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){
        //转发
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        //转发
        return "forward:/test/model";
    }


    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        //重定向：地址会变
        return "redirect:/test/model";
    }


}
