package com.cyx.java_web.web_01_servlet.servlet_10_cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/cookie/register")
public class ServletCookieDemo extends HttpServlet {
    private static final long serialVersionUID = 5701998687107457955L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = "无操作";

        req.setCharacterEncoding("UTF-8");
        String account = req.getParameter("account");
        // 获取请求中的 Cookie 对象
        Cookie[] cookies = req.getCookies();
        if (cookies == null || cookies.length < 1) {    // 若请求头中没有 Cookie 信息
            // 创建 Cookie 对象（因为 Cookie 中的属性名和属性值都不能为中文，所以在这里先对中文进行编码，再存入 Cookie）
            Cookie cookie = new Cookie("account", URLEncoder.encode(account, "UTF-8"));
            // 将 Cookie 对象放入响应对象，返回给浏览器
            resp.addCookie(cookie);

            title = "注册成功，账号为：" + account;
        } else {        // 若请求头中有 Cookie 信息
            for (Cookie cookie: cookies) {
                if ("account".equals(cookie.getName())) {
                    // 因为存入 Cookie 时对中文做了编码，所以在这里要对拿到的 Cookie 属性值做解码
                    title = "登陆成功，旧账号为：" + URLDecoder.decode(cookie.getValue() + "，新账号为：" + account, "UTF-8");
                    // 修改 Cookie 对象的属性值
                    // 方式一：创建新的 Cookie 对象，并设置相同的属性名
                    // Cookie newCookie = new Cookie("account", URLEncoder.encode(account, "UTF-8"));
                    // 方式二：使用该 Cookie 对象的 setValue() 方法，重新设置属性值
                    cookie.setValue(URLEncoder.encode(account, "UTF-8"));
                    // 注意，要将 Cookie 对象放入 Response 对象中，这样浏览器才可以从响应头中获取到 Cookie 信息
                    resp.addCookie(cookie);
                }
            }
        }

        // 响应操作
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print(title);
    }
}
