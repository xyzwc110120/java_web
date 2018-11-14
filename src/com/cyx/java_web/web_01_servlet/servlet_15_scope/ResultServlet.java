package com.cyx.java_web.web_01_servlet.servlet_15_scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = -3349413950616503558L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        /* 在浏览器中打印不同作用域对象中的属性值 */
        writer.print("<h3>NUM_IN_REQUEST = " + req.getAttribute("NUM_IN_REQUEST") + "</h3>");
        writer.print("<br/>");
        writer.print("<h3>NUM_IN_SESSION = " + req.getSession().getAttribute("NUM_IN_SESSION") + "</h3>");
        writer.print("<br/>");
        writer.print("<h3>NUM_IN_APPLICATION = " + req.getServletContext().getAttribute("NUM_IN_APPLICATION") + "</h3>");
    }
}
