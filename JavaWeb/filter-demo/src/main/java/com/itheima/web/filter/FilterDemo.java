package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author blind
 * @create 2022-11-23-16:32
 */
//@WebFilter("/*")
@WebFilter("/hello.jsp")
public class FilterDemo implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



        //1.放行前，对servletRequest数据进行处理
        System.out.println("1.FilterDemo...");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        //2.放行后，对servletResponse数据进行处理

        System.out.println("5.FilterDemo...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
