package com.cyx.java_web.web_03_CRUD.web.servlet.student;

import com.cyx.java_web.web_03_CRUD.dao.IStudentDAO;
import com.cyx.java_web.web_03_CRUD.dao.impl.StudentDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/edit")
public class StudentEditServlet extends HttpServlet {
    private static final long serialVersionUID = -8506061674850950259L;

    private IStudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if (id != null) {
            req.setAttribute("student", dao.get(Long.valueOf(id)));
        }
        req.getRequestDispatcher("/WEB-INF/views/student/studentEdit.jsp").forward(req, resp);
    }
}
