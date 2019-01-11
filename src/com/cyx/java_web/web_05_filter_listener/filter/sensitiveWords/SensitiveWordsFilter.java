package com.cyx.java_web.web_05_filter_listener.filter.sensitiveWords;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/filter/message")
public class SensitiveWordsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // HttpServletRequest 接口中有 getParameter 方法，却没有 setParameter 方法，所以不能对请求参数中的敏感字做处理
        // req.getParameter("message");

        // 使用装饰类
        MessageRequestWrapper wrapper = new MessageRequestWrapper(req);

        chain.doFilter(wrapper, resp);
    }

    @Override
    public void destroy() {
    }
}
