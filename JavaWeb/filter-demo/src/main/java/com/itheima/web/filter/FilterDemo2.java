package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author blind
 * @create 2022-11-23-16:32
 */
@WebFilter("/hello.jsp")
//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



        //1.放行前，对servletRequest数据进行处理
        System.out.println("2.FilterDemo...");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        //2.放行后，对servletResponse数据进行处理

        System.out.println("4.FilterDemo...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
