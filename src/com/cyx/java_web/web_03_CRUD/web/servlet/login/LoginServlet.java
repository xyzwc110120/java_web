package com.cyx.java_web.web_03_CRUD.web.servlet.login;

import com.cyx.java_web.web_03_CRUD.dao.IUserDAO;
import com.cyx.java_web.web_03_CRUD.dao.impl.UserDAOImpl;
import com.cyx.java_web.web_03_CRUD.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = -4146975201098031997L;

    private IUserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取需要执行的操作参数
        if ("logout".equals(req.getParameter("opt"))) {
            logout(req, resp);
        } else {
            login(req, resp);
        }
    }

    /**
     * 登录操作
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 防止有中文
        req.setCharacterEncoding("UTF-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String verificationCode = req.getParameter("verificationCode");
        String realVerificationCode = (String) req.getSession().getAttribute("VERIFICATION_CODE_IN_SESSION");

        // 判断验证码是否正确
        if (!verificationCode.equals(realVerificationCode)) {
            req.setAttribute("errorMsg", "验证码错误或已过期");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        // 获取对应账号用户信息
        User user = userDAO.getUserByAccount(account);

        if (user == null) {         // 若未找到对应用户信息，返回错误信息
            req.setAttribute("errorMsg", "该账号不存在");
        } else {                    // 若找到对应用户信息，验证密码是否正确
            if (password.equals(user.getPassword())) {
                // 登陆成功，将用户信息存入 session
                req.getSession().setAttribute("USER_IN_SESSION", user);
                resp.sendRedirect(req.getContextPath() + "/product");
                return;
            } else {
                req.setAttribute("errorMsg", "账号或密码错误");
            }
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    /**
     * 注销
     */
    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1、删除 session 中的 USER_IN_SESSION 属性
        // req.getSession().removeAttribute("USER_IN_SESSION");

        // 2、销毁整个 session 对象
        req.getSession().invalidate();
        /* 最常用的是第二种方法 */

        // 返回登陆页面
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
