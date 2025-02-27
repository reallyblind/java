package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author blind
 * @create 2023-02-03-14:42
 *
 * 1.@RequestMapping注解标识的位置：
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 *
 * 2.@RequestMapping注解value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 *
 * 3.@RequestMapping注解method属性
 *  作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送请求的请求方式匹配method属性中的任何一种请求方式
 * 则当前请求就会被注解所标识的方法进行处理
 *  若浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配，但是请求方式不匹配
 *  此时页面报错：405 - Request method 'xxx' not supported
 *
 * 在@RequestMapping的基础上，结合请求方式的一些派生注解：
 * @GetMapping,@PostMapping,@DeleteMapping,@PutMapping
 *
 * 4.@RequestMapping注解params属性
 *作用：通过请求的请求参数匹配请求，即当前浏览器所发送请求的请求参数必须满足params属性的设置
 *params可以使用四种表达式：
 * "param"：要求请求映射所匹配的请求必须携带param请求参数
 * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
 * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
 * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
 *
 * 5.@RequestMapping注解header属性
 * 作用：通过请求的请求头匹配请求，即当前浏览器所发送请求的请求头必须满足headers属性的设置
 *  refers：表示是否有上一个页面跳过来
 *
 * 6.SpringMVC支持ant风格的路径
 * 在@RequestMapping注解的属性值设置一些特殊字符
 * ?:任意的单个字符(不包括?)
 * *:任意个数的任意字符(不包括?和/)
 * **:任意层数的任意目录，注意使用方式只能/**/
/**
 * 7.@RequestMapping注解使用路径中的占位符
 * 传统:/deleteUser?id=1
 * rest:/user/delete/1
 * 需要在@RequestMapping注解的value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
 * 在通过@PathVariable注解，将占位符所标识的值和控制器方法的形参进行绑定
 *
 *
 *
 *
 */
//

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器方法所匹配的请求的请求路径为/test/hello
    @RequestMapping(value = {"/hello","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET},
            params={"username"}
    )
    public String hello(){
        return "success";
    }

    @RequestMapping("/a?a/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username")String username){
        System.out.println("id:"+id);
        System.out.println("username:"+username);
        return "success";
    }


}
