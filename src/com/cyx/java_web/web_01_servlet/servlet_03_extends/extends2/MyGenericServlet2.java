package com.cyx.java_web.web_01_servlet.servlet_03_extends.extends2;

import javax.servlet.*;
import java.io.Serializable;
import java.util.Enumeration;

/*
    让 MyGenericServlet2 实现 ServletConfig 接口，这样 MyGenericServlet2 的子类就可以直接使用实现后的方法，
    不需要再先去获取 ServletConfig 的对象 config

    因为要在网络中直接传输对象，所以要做序列化操作：实现 java.io.Serializable 接口
*/
public abstract class MyGenericServlet2 implements Servlet, ServletConfig, Serializable {

    private static final long serialVersionUID = 8732365328385299125L;
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest req, ServletResponse res);

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }


    /* ServletConfig 接口的实现方法： */

    @Override
    public String getServletName() {
        return this.config.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return this.config.getServletContext();
    }

    @Override
    public String getInitParameter(String name) {
        return this.config.getInitParameter(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return this.config.getInitParameterNames();
    }
}
