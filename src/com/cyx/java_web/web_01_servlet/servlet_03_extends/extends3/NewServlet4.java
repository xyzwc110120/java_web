package com.cyx.java_web.web_01_servlet.servlet_03_extends.extends3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet4 extends MyHttpServlet {

    private static final long serialVersionUID = -5980077155594784020L;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) {
        super.service(req, res);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("处理 GET 请求");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("处理 POST 请求");
    }
}
