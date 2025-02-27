package com.itheima.web.session; /**
 * @author blind
 * @create 2022-11-22-13:14
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/demo2" )
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据：从session中获取

        //1.获取Session对象
        HttpSession session = request.getSession();

        //销毁
        session.invalidate();

        //2.获取数据
        Object username = session.getAttribute("username");
        System.out.println(username);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
