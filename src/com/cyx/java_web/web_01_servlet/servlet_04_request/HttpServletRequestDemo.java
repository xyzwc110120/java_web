package com.cyx.java_web.web_01_servlet.servlet_04_request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

// 演示 HttpServletRequest 的方法
public class HttpServletRequestDemo extends HttpServlet {

    private static final long serialVersionUID = -8205486614896979363L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 01：String  getMethod()：返回请求方式，如 GET/POST。
        System.out.println(req.getMethod());

        // 02：String  getRequestURI()：放回请求行中的资源名称部分：如 /java_web/hello。
        System.out.println(req.getRequestURI());

        // 03：StringBuffer  getRequestURL()：返回浏览器地址栏中的所有信息。
        System.out.println(req.getRequestURL());

        // 04：String  getContextPath()：返回当前项目的上下文路径
        // （Tomcat 根目录 / conf 目录下的 server.xml 文件中的 <Context /> 元素的 path 属性值）。
        System.out.println(req.getContextPath());

        // 05：String  getRemoteAddr()：返回发出请求的客户端的 IP 地址。
        System.out.println(req.getRemoteAddr());

        // 06：String  getHeader(String name)：返回指定名称的请求头的值。
        String userAgent = req.getHeader("User-Agent");
        System.out.println(userAgent);
        // 判断是否为谷歌浏览器
        System.out.println(userAgent.concat("Chrome"));

        System.out.println("-----------------------------------------------------------------");

        // 获取请求参数的方法：http://localhost:8081/java_web/requestDemo?name=cyx&like=dog&like=cat&age=18

        // 01：String  getParameter(String  name)：返回指定名称的参数值。
        System.out.println(req.getParameter("name"));

        // 02：String[]  getParameterValues(String  name)：返回指定名称的参数的多个参数值。
        System.out.println(Arrays.toString(req.getParameterValues("like")));

        // 03：Enumeration<String> getParameterNames()：返回所有参数名的 Enumeration 对象。
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }

        // 04：Map<String,  String[]>  getParameterMap()：返回所有的参数和值所组成的 Map 对象。
        System.out.println(req.getParameterMap());
    }
}
