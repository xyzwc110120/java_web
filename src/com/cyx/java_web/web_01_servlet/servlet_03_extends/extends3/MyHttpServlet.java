package com.cyx.java_web.web_01_servlet.servlet_03_extends.extends3;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends MyGenericServlet3 {

    private static final long serialVersionUID = -7460729377280254166L;

    // 此方法只能处理一般的请求
    @Override
    public void service(ServletRequest req, ServletResponse res) {
        // 将请求和响应对象转换为专门处理 HTTP 类型请求和响应对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        // 调用专门处理 HTTP 类型的请求和响应的方法
        service(request, response);
    }

    // 专门处理 HTTP 类型的请求和响应的方法（使用 protected 访问权限，让子类可以覆盖）
    protected void service(HttpServletRequest req, HttpServletResponse res) {
        // 获取请求方式
        String method = req.getMethod();
        if ("GET".equals(method)) {
            doGet(req, res);
        } else if ("POST".equals(method)){
            doPost(req, res);
        }
    }

    // 专门处理 GET 请求（使用 protected 访问权限，让子类可以覆盖）
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
    }
    // 专门处理 POST 请求
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
    }

}
