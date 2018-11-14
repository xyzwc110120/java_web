package com.cyx.java_web.web_01_servlet.servlet_17_student.dao;

import com.cyx.java_web.web_01_servlet.servlet_17_student.domain.Student;

import java.util.List;

public interface IStudentDao {

    /**
     * 查询并返回所有学生对象
     *
     * @return 如果集合为空，返回一个空的 List 对象
     */
    List<Student> getAll();

}
