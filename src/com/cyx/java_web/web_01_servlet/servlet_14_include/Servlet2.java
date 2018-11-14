package com.cyx.java_web.web_01_servlet.servlet_14_include;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/include/s2")
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = -2753032670034379011L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet2 接受的参数为：" + req.getParameter("nickname"));

        System.out.println("步骤1：Servlet2，收到请求包含");

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print("Servlet2 的响应");
    }
}
