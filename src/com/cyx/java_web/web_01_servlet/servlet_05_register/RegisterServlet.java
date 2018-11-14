package com.cyx.java_web.web_01_servlet.servlet_05_register;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = -2463543678621453393L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        /*
            防止中文乱码，使用 javax.servlet.ServletRequest 接口中的 setCharacterEncoding(String env) 方法设置字符编码。
            注意：setCharacterEncoding 方法要放在获取参数之前，否则无效，并且只对 POST 请求有效。
        */
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> params = req.getParameterMap();
        Set<Map.Entry<String, String[]>> set = params.entrySet();
        for (Map.Entry<String, String[]> entry : set) {
            StringBuilder builder = new StringBuilder(entry.getKey()).append("：");
            for (String value : entry.getValue()) {
                builder.append(value).append("，");
            }
            System.out.println(builder);
        }
    }
}
