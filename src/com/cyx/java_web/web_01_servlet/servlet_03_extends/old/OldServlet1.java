package com.cyx.java_web.web_01_servlet.servlet_03_extends.old;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OldServlet1 implements Servlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        System.out.println(config.getInitParameter("name"));
    }

    @Override
    public ServletConfig getServletConfig() {
        // 将 ServletConfig 对象暴露给子类访问
        return this.config;
    }

    @Override
    public void destroy() {
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
