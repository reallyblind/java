package com.itheima.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author blind
 * @create 2022-11-25-10:57
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //释放资源

    }
}
