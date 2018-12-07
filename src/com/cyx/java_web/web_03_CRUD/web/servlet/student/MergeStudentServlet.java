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

// 每次请求都要单独写一个 Servlet，这样太麻烦，所以将相关操作合并到一个 Servlet 中。
@WebServlet("/student/merge")
public class MergeStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 2917348437449251547L;

    private IStudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 因为保存修改操作会出现中文，所以要设置字符集
        req.setCharacterEncoding("UTF-8");
        // 获取操作参数，查看请求需要做什么操作
        String opt = req.getParameter("opt") == null ? "" : req.getParameter("opt");
        switch (opt) {
            case "delete":
                delete(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            case "save":
                save(req, resp);
                break;
            default:
                list(req, resp);
        }
    }

    /**
     * 获取所有学生信息操作
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = dao.getAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/views/student/studentList.jsp").forward(req, resp);
    }

    /**
     * 删除指定学生
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (!isBlank(id)) {
            dao.delete(Long.valueOf(id));
        }
        // 这里通过 Request 对象.getContextPath() 方法获取上下文路径，而不是直接写死，这样就算改了项目上下文路径也不用改源码
        resp.sendRedirect(req.getContextPath() + "/student/merge?opt=list");

        /* 如果使用请求转发，会出现死循环，因为请求转发是共享请求数据的，所以 opt = delete 会一直进入删除操作 */
        // req.getRequestDispatcher("/student/merge").forward(req, resp);
        /* 请求转发只能在当前应用内转发，所以和重定向不同，请求转发会自带的加上项目上下文路径 */
    }

    /**
     * 进入学生信息编辑页面
     */
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (!isBlank(id)) {
            req.setAttribute("student", dao.get(Long.valueOf(id)));
        }
        req.getRequestDispatcher("/WEB-INF/views/student/studentEdit.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (isBlank(id)) {
            dao.add(new Student(req.getParameter("name"), Integer.valueOf(req.getParameter("age"))));
        } else {
            dao.update(new Student(Long.valueOf(id), req.getParameter(("name")), Integer.valueOf(req.getParameter("age"))));
        }
        resp.sendRedirect(req.getContextPath() + "/student/merge");
    }

    /**
     * 判断字符串是否为空
     */
    private boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }
}