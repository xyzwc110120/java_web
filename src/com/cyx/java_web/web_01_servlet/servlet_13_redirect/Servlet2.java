package com.cyx.java_web.web_01_servlet.servlet_13_redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect/s2")
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = -6481188488634138864L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet2 接受的参数为：" + req.getParameter("nickname"));

        System.out.println("步骤1：Servlet2，收到 URL 重定向");

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print("Servlet2 的响应");
    }
}
