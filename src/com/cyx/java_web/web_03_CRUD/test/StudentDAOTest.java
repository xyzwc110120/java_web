package com.cyx.java_web.web_03_CRUD.test;

import com.cyx.java_web.web_03_CRUD.dao.IStudentDAO;
import com.cyx.java_web.web_03_CRUD.dao.impl.StudentDAOImpl;
import com.cyx.java_web.web_03_CRUD.domain.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTest {

    private IStudentDAO studentDao = new StudentDAOImpl();

    @Test
    @DisplayName("测试获取所有学生信息")
    void testGetAll() {
        List<Student> students = studentDao.getAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
