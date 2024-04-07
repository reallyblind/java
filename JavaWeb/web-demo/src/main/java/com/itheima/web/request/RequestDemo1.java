package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author blind
 * @create 2022-11-17-15:43
 */
@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String getMethod():获取请求方式: GET
        //String getContextPath0:获取虚拟目录(项目访问路径): /request-demo
        //StringBuffer getRequestURL(:获取URL(统-资源定位符): http://ocalhost:8080/request-demo/req1
        //String getRequestURI():获取URI(统-资源标识符): /request-demo/req1
        //String getQueryString():获取请求参数(GET方式) : username=zhangsan&password=123


        //-------------
        //获取请求头:user-agent:浏览器的版本信息
        String agent = req.getHeader("user-agent");
        System.out.println(agent);
        //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post 请求体：请求参数

        //1.获取字符输入流
        BufferedReader br = req.getReader();
        //2.读取数据
        String line = br.readLine();
        System.out.println(line);

    }
}
