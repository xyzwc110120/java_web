package com.cyx.java_web.web_01_servlet.servlet_03_extends.extends2;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NewServlet2 extends MyGenericServlet2 {

    private static final long serialVersionUID = -6539657107078566490L;

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        System.out.println(super.getInitParameter("name"));
    }
}
