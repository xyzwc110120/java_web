package com.cyx.java_web.web_05_filter_listener.filter.characterEncoding;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* javax.servlet.Filter 接口没有关于字符编码可以直接用的实现类，需要我们自己写 */
public class CharacterEncodingFilter implements Filter {

    private String encoding;
    private Boolean force = false;

    @Override
    public void init(FilterConfig filterConfig) {
        // 获取配置的自定义字符编码
        encoding = filterConfig.getInitParameter("encoding");
        // 获取配置的是否强制使自定义字符编码
        force = Boolean.valueOf(filterConfig.getInitParameter("force"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 设置字符编码
        // 若自定义的字符编码不为空，并且用户没有设置编码或者强制使用我们配置的编码
        if (isNotBlank(encoding) && (req.getCharacterEncoding() == null || force)) {
            req.setCharacterEncoding(encoding);
        }

        // 放行
        chain.doFilter(req, resp);
    }

    /**
     * 判断字符串是否不为空或者内容不为空
     */
    private boolean isNotBlank(String str) {
        return str != null && !"".equals(str.trim());
    }

    @Override
    public void destroy() {
    }
}
