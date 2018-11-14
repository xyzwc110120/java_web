package com.cyx.java_web.web_01_servlet.servlet_06_response;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpServletResponseDemo extends HttpServlet {
    private static final long serialVersionUID = 3256069394767626195L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置输出的 MIME 类型（输出内容的类型）
        // resp.setContentType("text/html");
        // 设置输出内容的编码类型
        // resp.setCharacterEncoding("UTF-8");
        // 以上两行代码可以合并成一行
        resp.setContentType("text/html; charset=UTF-8");
        /* 注意：上述设置响应内容的方法必须在获取输出流对象前调用，否则无效 */

        // OutputStream stream = resp.getOutputStream();
        // stream.write("哇哈哈".getBytes());
        PrintWriter writer = resp.getWriter();
        writer.println("啦啦啦");
        writer.println("哇哈哈");
        /*
            注意：ServletOutputStream getOutputStream() 方法和 PrintWriter getWriter() 不可以同时使用，否则会报错：
                java.lang.IllegalStateException: getOutputStream() has already been called for this response
        */

    }
}
