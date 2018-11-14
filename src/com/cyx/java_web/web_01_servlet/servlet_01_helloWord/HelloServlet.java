package com.cyx.java_web.web_01_servlet.servlet_01_helloWord;

import javax.servlet.*;

public class HelloServlet implements Servlet {

    /*
        Servlet 类中必须有一个公共无参构造器，因为 Tomcat 底层创建 Servlet 对象使用的 Class对象.newInstance() 方法，
        该方法需要类中有一个公共无参构造器。
    */
    /**
     * 构造器会在服务端程序第一次被请求时执行，在 Servlet 整个生命周期只会执行这一次
     */
    public HelloServlet() {
        System.out.println("公共无参构造器，创建 Servlet 对象");
    }

    /**
     * 初始化方法，初始化 Servlet 对象，在构造器执行完毕后执行，和构造器一样，只会在第一次被请求时执行。
     */
    @Override
    public void init(ServletConfig config) {
        System.out.println("初始化 Servlet 对象");
    }

    /**
     * 服务方法，每次被请求都会执行该方法，Web 动态网页的操作酒编写在该方法
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) {
        System.out.println("Hello Word!!!");
    }

    /**
     * 销毁 Servlet 对象，正常关闭 Tomcat 才会执行。
     * （该方法不一定会被执行，所以没有必要在其中编写扫尾的操作）
     */
    @Override
    public void destroy() {
        System.out.println("销毁 Servlet 对象");
    }


    /**
     * 获取 Servlet 的配置信息对象
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 获取 Servlet 的信息（Servlet 的作者、版本、版权相关）
     */
    @Override
    public String getServletInfo() {
        return null;
    }

}
