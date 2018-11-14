package com.cyx.java_web.web_01_servlet.servlet_08_annotation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/* 注意：再注解中配置资源名称，与在 web.xml 中一样，必须以“/”开头 */
// 配置资源名称
// @WebServlet("/annotation")
// 配置多个资源名称
// @WebServlet({"/annotation", "/ann"})
// 配置初始化参数
// @WebServlet(value = "/annotation", initParams = @WebInitParam(name = "encoding", value = "UTF-8"))
// 配置多个初始化参数
@WebServlet(value = "/annotation", initParams = {
        @WebInitParam(name = "encoding", value = "UTF-8"),
        @WebInitParam(name = "name", value = "cyx")}, loadOnStartup = 1)
public class ServletAnnotationDemo extends HttpServlet {
    private static final long serialVersionUID = -4222793843973474462L;

    public ServletAnnotationDemo() {
        System.out.println("创建对象");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("初始化操作");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("通过注解访问");
        Enumeration<String> names = super.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + " = " + super.getInitParameter(name));
        }
    }
}
