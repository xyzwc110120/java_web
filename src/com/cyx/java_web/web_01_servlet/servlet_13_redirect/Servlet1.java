package com.cyx.java_web.web_01_servlet.servlet_13_redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/redirect/s1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = -647260952132450427L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet1 接受的参数为：" + req.getParameter("nickname"));

        System.out.println("步骤1：Servlet1，URL 重定向前");

        // URL 重定向
        /* URL 重定向和请求转发的目标资源名称规则是一样的： 以 “/” 开头则表示绝对路径，否则则为相对路径。 */
        /* 这里有点不一样的是要加上项目的上下文路径 */
        resp.sendRedirect("/java_web/redirect/s2");

        System.out.println("步骤2：Servlet1，URL 重定向后");
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print("Servlet1 的响应");
    }
}

