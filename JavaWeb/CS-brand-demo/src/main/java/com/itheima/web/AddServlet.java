package com.itheima.web; /**
 * @author blind
 * @create 2022-11-26-18:55
 */

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService=new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据,request.getParameter 不能接受JSON的数据
//        String brandName = request.getParameter("brandName");

        //获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);
//        System.out.println(brand);

        //2.调用service添加
        brandService.add(brand);

        //3.响应成功标识
        response.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
