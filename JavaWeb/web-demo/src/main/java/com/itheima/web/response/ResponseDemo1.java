package com.itheima.web.response; /**
 * @author blind
 * @create 2022-11-20-15:58
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1....");
/*
        //重定向
        //1.设置响应状态码 302
        response.setStatus(302);
        //2.设置响应头 Location
        response.setHeader("Location","/web-demo/resp2");
*/

        //简化方式完成重定向
        //动态获取虚拟目录
        String contextPath = request.getContextPath();

        response.sendRedirect(contextPath+"/resp2");
        //response.sendRedirect("www.baidu.com");
        //response.sendRedirect("/web-demo/resp2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
