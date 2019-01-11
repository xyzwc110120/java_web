package com.cyx.java_web.web_05_filter_listener.filter.detail.sequence;

import javax.servlet.*;
import java.io.IOException;

public class SequenceFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("before······SequenceFilter1······");
        chain.doFilter(request, response);
        System.out.println("after······SequenceFilter1······");
    }

    @Override
    public void destroy() {
    }
}
