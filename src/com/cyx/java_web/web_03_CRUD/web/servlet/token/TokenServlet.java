package com.cyx.java_web.web_03_CRUD.web.servlet.token;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/token/generateToken")
public class TokenServlet extends HttpServlet {
    private static final long serialVersionUID = 8325244001890785350L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 首先生成一个唯一的令牌
        String token = UUID.randomUUID().toString();
        // 存放于 session 中以用于之后的验证
        req.getSession().setAttribute("TOKEN_IN_SESSION", token);
        // 将令牌发送至表单页面
        req.setAttribute("token", token);
        req.getRequestDispatcher("/WEB-INF/views/token/input.jsp").forward(req, resp);
    }
}
