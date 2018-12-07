package com.cyx.java_web.web_03_CRUD.dao;

import com.cyx.java_web.web_03_CRUD.domain.Student;

import java.util.List;

public interface IStudentDAO {

    /**
     * 删除指定学生
     * 
     * @param id 学生id
     */
    void delete(Long id);

    /**
     * 新增学生
     *
     * @param student 学生信息
     */
    void add(Student student);

    /**
     * 修改指定学生信息
     *
     * @param student 学生信息
     */
    void update(Student student);

    /**
     * 获取指定学生信息
     *
     * @param id 学生id
     * @return 学生信息
     */
    Student get(Long id);

    /**
     * 查询并返回所有学生对象
     *
     * @return 如果集合为空，返回一个空的 List 对象
     */
    List<Student> getAll();

}
