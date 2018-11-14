package com.cyx.java_web.web_01_servlet.servlet_02_initParam;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Enumeration;

public class InitParamServlet implements Servlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) {
        // 这里我们不需要实现 ServletConfig 接口，因为 Tomcat 已经帮我们实现了
        this.config = config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        // 获取参数名为 encoding 的初始化参数值
        String encoding = config.getInitParameter("encoding");
        if ("GBK".equals(encoding)) {
            System.out.println("你好世界");
        } else {
            System.out.println("Hello Word");
        }
        System.out.println("-----------------------------------------------------------------");
        // 获取所有初始化参数名和值（Enumeration 接口是 Iterator 迭代器的“古老版本”）
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + "：" + config.getInitParameter(name));
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
