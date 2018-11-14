package com.cyx.java_web.web_01_servlet.servlet_11_session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session/sessionDemo")
public class ServletSessionDemo extends HttpServlet {
    private static final long serialVersionUID = 7710638746737984106L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String nickname = req.getParameter("nickname");

        String msg = "新名称为：" + nickname;
        HttpSession session = req.getSession(false);
        if (session != null) {
            msg += "，旧名称为：" + session.getAttribute("nickname");
        } else {
            session = req.getSession();
            session.setAttribute("NICKNAME_IN_SESSION", nickname);
        }

        System.out.println(resp.encodeURL("/java_web/session/sessionDemo"));

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print(msg);
    }
}
