package com.cyx.java_web.web_01_servlet.servlet_03_extends.extends3;

import javax.servlet.*;
import java.io.Serializable;
import java.util.Enumeration;

public abstract class MyGenericServlet3 implements Servlet, ServletConfig, Serializable {

    private static final long serialVersionUID = 699571359966541328L;
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
        /*
            这里表面上看在调用自身的 init() 方法，但是此时 NewServlet3 覆盖了 init() 方法，从多态时方法调用上分析，
            此时 init() 方法，其实调用的是子类 NewServlet3 的 init() 方法
        */
        init();
    }

    // 提供一个无参的初始化方法暴露给子类使用（不使用抽象方法是因为子类不需要非要做自身的初始化操作）
    public void init() {
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
