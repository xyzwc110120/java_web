package com.cyx.java_web.web_05_filter_listener.filter.detail.dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filter/dispatcher")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = -4398403992575509542L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向
        // resp.sendRedirect(req.getContextPath() + "/filter/hello/hello.jsp");
        /*
            控制台打印：
                拦截请求：/java_web/filter/dispatcher
                执行过滤操作

            因为重定向相当于两次独立的请求，所以拦截器会拦截两次
        */

        // 请求转发
        req.getRequestDispatcher("/filter/hello/hello.jsp").forward(req, resp);
        /*
            控制台打印：
                拦截请求：/java_web/filter/dispatcher

            因为请求转发相当于一个请求，所以只拦截了一次。
            在 web.xml 中配置了 dispatcher 元素后，便可以对请求转发做拦截：
            控制台打印：
                拦截请求：/java_web/filter/dispatcher
                拦截请求：/java_web/filter/hello/hello.jsp
        */
    }
}
