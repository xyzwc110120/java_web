package com.cyx.java_web.web_01_servlet.servlet_16_servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContext")
public class ServletContextDemo extends HttpServlet {
    private static final long serialVersionUID = -4784767752376011017L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 ServletContext 对象的三种方式
        // 1、通过调用父类中的方法来获取：
        ServletContext context1 = super.getServletContext();
        // 2、通过 Request 对象来获取：
        ServletContext context2 = req.getServletContext();
        // 3、通过 Session 对象来获取：
        ServletContext context3 = req.getSession().getServletContext();
        System.out.println(context1 == context2);       // true
        System.out.println(context1 == context3);       // true
        System.out.println(context2 == context3);       // true

        // ServletContext 接口的常用方法：
        // 1、String  getRealPath(String  Path)：根据一个资源的相对于 Web 根目录的路劲，获取它的绝对路径：
        System.out.println(context1.getRealPath("/WEB-INF/index.html"));
        // String  getContextPath()：返回当前响应的上下文路径
        // （就是 Tomcat 中 conf 目录里 server.xml 中所配置的 <Context path="XXX"> 元素的 path 属性）:
        System.out.println(context1.getContextPath());      // /java_web
    }
}
