package com.cyx.java_web.web_01_servlet.servlet_03_extends.extends1;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
    应为每个 Servlet 需要在 service 方法中做不同的响应操作，所以将父类中的 service 方法写成抽象方法，由子类自己去实现
*/
public abstract class MyGenericServlet1 implements Servlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
    }

    @Override
    abstract public void service(ServletRequest req, ServletResponse res);

    @Override
    public ServletConfig getServletConfig() {
        // 将 ServletConfig 对象暴露给子类访问
        return this.config;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
