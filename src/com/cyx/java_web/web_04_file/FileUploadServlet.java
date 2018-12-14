package com.cyx.java_web.web_04_file;

import com.cyx.java_web.exception.ImageUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/file/upload")
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = -8787666000145855476L;



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用扫描器输出请求对象的请求体的流信息
        // Scanner scanner = new Scanner(req.getInputStream());
        // while (scanner.hasNextLine()) {
        //     System.out.println(scanner.nextLine());
        // }

        // 使用封装的上传工具类上传
        try {
            FileUtil.upload(req);
        } catch (ImageUploadException e) {
            // 获取抛出的异常信息
            req.setAttribute("errorMsg", e.getMessage());
            req.getRequestDispatcher("/fileDemo/fileUpload.jsp").forward(req, resp);
        }
    }
}