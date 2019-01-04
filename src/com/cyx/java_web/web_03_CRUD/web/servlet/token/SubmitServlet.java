package com.cyx.java_web.web_03_CRUD.web.servlet.token;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/token/submit")
public class SubmitServlet extends HttpServlet {
    private static final long serialVersionUID = -3137406191566515991L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // 获取请求和 session 中的令牌，然后比较
        String tokenInRequest = req.getParameter("token");
        String tokenInSession = (String) session.getAttribute("TOKEN_IN_SESSION");
        // 销毁 session 中的令牌
        session.removeAttribute("TOKEN_IN_SESSION");

        if (!tokenInRequest.equals(tokenInSession)) {
            System.out.println("令牌不匹配，提交失败");
        } else {
            System.out.println("提交成功");
        }
    }
}