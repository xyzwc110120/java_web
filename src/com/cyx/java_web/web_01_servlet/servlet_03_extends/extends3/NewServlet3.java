package com.cyx.java_web.web_01_servlet.servlet_03_extends.extends3;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NewServlet3 extends MyGenericServlet3 {

    private static final long serialVersionUID = -7707655909292920623L;

    @Override
    public void init() {
        System.out.println("执行自身的初始化操作");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        System.out.println("自身的 service 方法");
    }
}
