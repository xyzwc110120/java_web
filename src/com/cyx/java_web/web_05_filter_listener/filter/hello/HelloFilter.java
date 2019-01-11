package com.cyx.java_web.web_05_filter_listener.filter.hello;

import javax.servlet.*;
import java.io.IOException;

public class HelloFilter implements Filter {

    public HelloFilter() {
        System.out.println("执行构造器！！！");
    }

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("执行初始化方法！！！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行过滤操作");
        /* 放行操作（不然请求无法发送至 Servlet） */
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
