package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author blind
 * @create 2022-11-16-16:34
 */

@WebServlet("/demo5")
public class ServletDemo5 implements Servlet {



    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //根据请求方式的不同，进行分别的处理

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //1.获取请求方式
        String method = request.getMethod();
        //2.判断
        if("GET".equals(method)){
            //get 处理方式
        }else if ("POST".equals(method)){
            //post方式的处理逻辑
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



}
