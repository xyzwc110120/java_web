package com.cyx.java_web.web_01_servlet.servlet_12_forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward/s1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = -9078986051121198476L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("Servlet1 接受的参数为：" + req.getParameter("nickname"));
        System.out.println("Servlet1 的 Request 对象：" + req);

        System.out.println("步骤1：Servlet1，请求转发前");
        // 请求转发
        /*
            若转发请求的路径前没有加“/”的话，则表示使用当前资源的相对路径（也就是当前资源路径（/forward/s1）最后一个“/”之前的部分（/forward））
            若路径前以“/”开头的话，则意味着使用绝对路径（其实是相对与该项目的 web 根目录而已）
        */
        // req.getRequestDispatcher("forward/s2").forward(req, resp);       // 使用的相对路径，请求转发资源路径为：/forward/forward/s2
        req.getRequestDispatcher("/forward/s2").forward(req, resp);   // 使用的绝对路径，请求转发资源路径为：/forward/s2
        // req.getRequestDispatcher("www.baidu.com").forward(req, resp);    // 请求转发不可以跨域访问，只能跳转到当前应用中的资源
        // req.getRequestDispatcher("/WEB-INF/web.xml").forward(req, resp); // 使用请求转发可以访问 WEB-INF 目录中的资源

        System.out.println("步骤2：Servlet1，请求转发后");
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print("Servlet1 的响应");
    }
}
