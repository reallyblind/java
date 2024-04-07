package com.atguigu.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author blind
 * @create 2023-02-09-14:06
 *
 * 用来代替web.xml
 *
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    //设置一个配置类代替spring的配置文件
    protected Class<?>[] getRootConfigClasses() {

        return new Class[]{SpringConfig.class};
    }

    @Override
    //设置一个配置类代替springMVC的配置文件
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }


    @Override
    //设置springMVC的前端控制器DisPatcherServlet的url-pattern
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    //设置当前的过滤器
    protected Filter[] getServletFilters() {
        //创建编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        //创建处理请求方式的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();


        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
