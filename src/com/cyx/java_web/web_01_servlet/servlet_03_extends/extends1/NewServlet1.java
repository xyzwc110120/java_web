package com.cyx.java_web.web_01_servlet.servlet_03_extends.extends1;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NewServlet1 extends MyGenericServlet1 {

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        System.out.println(super.getServletConfig().getInitParameter("name"));
    }

}
