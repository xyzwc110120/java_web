package com.cyx.java_web.web_05_filter_listener.filter.sensitiveWords;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filter/message")
public class MessageServlet extends HttpServlet {
    private static final long serialVersionUID = 2483484476998774169L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("message"));
    }
}
