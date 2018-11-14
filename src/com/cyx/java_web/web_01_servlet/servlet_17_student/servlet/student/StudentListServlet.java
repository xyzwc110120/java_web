package com.cyx.java_web.web_01_servlet.servlet_17_student.servlet.student;

import com.cyx.java_web.web_01_servlet.servlet_17_student.dao.IStudentDao;
import com.cyx.java_web.web_01_servlet.servlet_17_student.dao.impl.StudentDaoImpl;
import com.cyx.java_web.web_01_servlet.servlet_17_student.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/studentList")
public class StudentListServlet extends HttpServlet {
    private static final long serialVersionUID = 3023450063895511580L;

    private IStudentDao studentDao;

    @Override
    public void init() throws ServletException {
        /*
            因为 Servlet 是单例的，而在 Servlet 中使用成员变量会造成线程不安全，所以在初始化的时候创建对象，
            这样 studentDao 在该 Servlet 中也就只有一个对象了。
        */
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先从数据库中获取数据
        List<Student> students = studentDao.getAll();

        // 将数据放入请求传至 JSP 页面
        req.setAttribute("students", students);
        // 请求转发
        req.getRequestDispatcher("/WEB-INF/views/student/studentList.jsp").forward(req, resp);
    }
}
