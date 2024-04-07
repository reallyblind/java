package com.atguigu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author blind
 * @create 2023-02-09-12:28
 */
//将当前类标识为异常处理的组件
@ControllerAdvice
public class exceptionController {

    //设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex,Model model){
        //ex表示控制器方法所出现的异常
        model.addAttribute("ex",ex);
        return "error";
    }


}
