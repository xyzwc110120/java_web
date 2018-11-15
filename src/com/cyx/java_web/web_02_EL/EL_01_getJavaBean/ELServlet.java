package com.cyx.java_web.web_02_EL.EL_01_getJavaBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EL/getJavaBean")
public class ELServlet extends HttpServlet {
    private static final long serialVersionUID = 6485529049294007129L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("person", new Person());
        req.getRequestDispatcher("/ELDemo/getJavaBean.jsp").forward(req, resp);
    }
}