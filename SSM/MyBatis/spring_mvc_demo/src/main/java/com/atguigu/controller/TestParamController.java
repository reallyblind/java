package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author blind
 * @create 2023-02-04-10:49
 *
 * 获取请求参数的方式:
 * 1.通过servletAPI获取
 *   只需要在控制器方法的形参位置设置HttpServletRequest类型的形参，就可以在控制器方法中使用request对象获取请求参数
 * 2.通过控制器方法的形参获取
 *  只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可
 * 3.@RequestParam：将请求参数和控制器方法的形参绑定
 *  @RequestParam注解一共有三个属性：
 * value：指定为形参赋值的请求参数的参数名
 * required：设置是否必须传输value所对应的请求参数，默认值为true
 * 若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置
 * defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；
 * 若设置为false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null
 * defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值
 * 为""时，则使用默认值为形参赋值
 * 4.@RequestHeader:将请求头信息和控制器方法的形参绑定
 * 5.@CookieValue:将cookie数据和控制器方法的形参绑定
 * 6.通过控制器方法的实体类类型的形参获取请求参数
 *  需要在控制器方法的形参位置设置实体类类型的形参，要保证实体类中的属性的属性名和请求参数的名字一致，
 *  可以通过实体类类型的形参获取请求参数
 * 7.解决获取请求此参数的乱码问题
 *  在web.xml中配置Spring的编码过滤器CharacterEncodingFilter
 *
 *
 *
 */
@Controller
public class TestParamController {

    @RequestMapping(value = "/param/servletAPI",method = RequestMethod.GET)
    public String getParamByServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username"+username+",password"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "userName",required = false,defaultValue = "hello") String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }


    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";

    }






}
