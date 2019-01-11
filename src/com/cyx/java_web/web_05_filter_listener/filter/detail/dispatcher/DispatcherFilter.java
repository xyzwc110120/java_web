package com.cyx.java_web.web_05_filter_listener.filter.detail.dispatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DispatcherFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将父类强转为子类，因为某些方法只有子类有
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("拦截请求：" + httpServletRequest.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
