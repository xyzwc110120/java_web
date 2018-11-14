package com.cyx.java_web.web_01_servlet.servlet_17_student.test;

import com.cyx.java_web.web_01_servlet.servlet_17_student.dao.IStudentDao;
import com.cyx.java_web.web_01_servlet.servlet_17_student.dao.impl.StudentDaoImpl;
import com.cyx.java_web.web_01_servlet.servlet_17_student.domain.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDaoTest {

    private IStudentDao studentDao = new StudentDaoImpl();

    @Test
    @DisplayName("测试获取所有学生信息")
    void testGetAll() {
        List<Student> students = studentDao.getAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
