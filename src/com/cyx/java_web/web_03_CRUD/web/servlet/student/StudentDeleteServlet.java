package com.cyx.java_web.web_03_CRUD.web.servlet.student;

import com.cyx.java_web.web_03_CRUD.dao.IStudentDAO;
import com.cyx.java_web.web_03_CRUD.dao.impl.StudentDAOImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1770893708855793931L;

    private IStudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        dao.delete(id);
        // 重定向，重新获取学生列表并跳转页面
        resp.sendRedirect("/java_web/student/list");
    }
}
