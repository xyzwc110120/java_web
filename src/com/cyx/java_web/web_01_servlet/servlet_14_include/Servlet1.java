package com.cyx.java_web.web_01_servlet.servlet_14_include;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/include/s1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = -6416323466299494723L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet1 接受的参数为：" + req.getParameter("nickname"));

        System.out.println("步骤1：Servlet1，请求包含前");

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print("Servlet1 的响应");

        /* 这里注意，要将请求包含放置在配置响应对象的后面，不然会乱码 */
        // 请求包含
        req.getRequestDispatcher("/include/s2").include(req, resp);

        System.out.println("步骤2：Servlet1，请求包含后");
    }
}
