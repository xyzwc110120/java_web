package com.cyx.java_web.web_05_filter_listener.filter.checkLogin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckLoginFilter implements Filter {

    // 存入 session 的名称
    private String sessionName;

    @Override
    public void init(FilterConfig filterConfig) {
        sessionName = filterConfig.getInitParameter("sessionName");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Object user = req.getSession().getAttribute(sessionName);
        // 若没有登陆
        if (user == null) {
            // 重定向至登陆页面
            resp.sendRedirect(req.getContextPath() + "/filter/characterEncoding/login.jsp");
            return;
        }
        // 若已登陆，则放行
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}