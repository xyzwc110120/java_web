package com.cyx.java_web.web_04_file;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/file/download")
public class FileDownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 5877643993777587207L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取文件名称
        String filename = req.getParameter("filename");
        // 从服务器中找到要下载资源的绝对路径
        String realPath = super.getServletContext().getRealPath("/WEB-INF/download/" + filename);
        System.out.println(realPath);

        /* 告诉浏览器不要直接打开资源，而是弹出下载框，保存文件 */
        resp.setContentType("application/x-msdownload");
        /* 设置下载文件的建议保存名字 */
        // 服务器发给浏览器的数据默认是按照 ISO-8859-1 编码，所以需要先用 UTF-8 编码还原，在使用 ISO-8859-1 解码
        // 这里注意，IE 浏览器的编码方式不太一样，所以要分开处理
        // 获取请求的浏览器
        String userAgent = req.getHeader("User-Agent");
        if (userAgent.contains("Edge")) {
            // IE 浏览器
            filename = URLEncoder.encode(filename, "UTF-8");
        } else {
            // 非 IE 浏览器
            filename = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        }
        resp.setHeader("Content-Disposition", "attachment; filename=" + filename);

        // 将服务器磁盘中的资源放置响应对象的输出流中（这里要用字节流，而不能用字符流）
        Files.copy(Paths.get(realPath), resp.getOutputStream());
    }
}