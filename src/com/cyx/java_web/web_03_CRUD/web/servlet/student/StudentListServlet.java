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
import java.util.List;

// 获取学生列表
@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
    private static final long serialVersionUID = -5034965252519637252L;

    private IStudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = dao.getAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/views/student/studentList.jsp").forward(req, resp);
    }
}