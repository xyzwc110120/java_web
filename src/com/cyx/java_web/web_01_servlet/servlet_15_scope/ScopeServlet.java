package com.cyx.java_web.web_01_servlet.servlet_15_scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    private static final long serialVersionUID = -5019704972529731347L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* request */
        Integer requestNum = (Integer) req.getAttribute("NUM_IN_REQUEST");
        // 每次请求，请求对象 NUM_IN_REQUEST 属性属性值自增 1
        if (requestNum == null) {
            req.setAttribute("NUM_IN_REQUEST", 1);
        } else {
            req.setAttribute("NUM_IN_REQUEST", ++requestNum);
        }

        /* session */
        HttpSession session = req.getSession();
        Integer numSession = (Integer) session.getAttribute("NUM_IN_SESSION");
        // 每次请求，会话对象 NUM_IN_SESSION 属性属性值自增 1
        if (numSession == null) {
            session.setAttribute("NUM_IN_SESSION", 1);
        } else {
            session.setAttribute("NUM_IN_SESSION", ++numSession);
        }

        /* servletContext */
        ServletContext application = req.getServletContext();
        Integer numApplication = (Integer) application.getAttribute("NUM_IN_APPLICATION");
        // 每次请求，应用对象 NUM_IN_APPLICATION 属性属性值自增 1
        if (numApplication == null) {
            application.setAttribute("NUM_IN_APPLICATION", 1);
        } else {
            application.setAttribute("NUM_IN_APPLICATION", ++numApplication);
        }

        // 因为要共享请求对象的数据，所以要用请求转发
        req.getRequestDispatcher("/result").forward(req, resp);
    }
}
