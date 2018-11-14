package com.cyx.java_web.web_01_servlet.servlet_12_forward;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward/s2")
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = -4038523664470380419L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Servlet2 接受的参数为：" + req.getParameter("nickname"));
        System.out.println("Servlet2 的 Request 对象：" + req);

        System.out.println("步骤1：Servlet2，收到请求转发");

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print("Servlet2 的响应");
    }
}
