package com.cyx.java_web.web_03_CRUD.web.servlet.student;

import com.cyx.java_web.web_03_CRUD.dao.IStudentDAO;
import com.cyx.java_web.web_03_CRUD.dao.impl.StudentDAOImpl;
import com.cyx.java_web.web_03_CRUD.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/save")
public class StudentSaveServlet extends HttpServlet {
    private static final long serialVersionUID = 2090680043828830075L;

    private IStudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 因为学生名字有中文，所以设置字符编码，以防乱码
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        if (id == null || id.trim().equals("")) {
            Student student = new Student(name, Integer.valueOf(age));
            dao.add(student);
        } else {
            Student student = new Student(Long.valueOf(id), name, Integer.valueOf(age));
            dao.update(student);
        }

        // 重定向
        resp.sendRedirect("/java_web/student/list");
    }
}
