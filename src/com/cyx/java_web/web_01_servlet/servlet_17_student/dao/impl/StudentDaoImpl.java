package com.cyx.java_web.web_01_servlet.servlet_17_student.dao.impl;

import com.cyx.java_web.web_01_servlet.servlet_17_student.dao.IStudentDao;
import com.cyx.java_web.web_01_servlet.servlet_17_student.domain.Student;
import com.cyx.java_web.web_01_servlet.servlet_17_student.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {

    @Override
    public List<Student> getAll() {
        String sql = "SELECT s.id, s.`name`, s.age FROM student s";
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;

        try {
            // 获得链接对象
            connection = JdbcUtil.getConnection();
            // 获得语句对象
            statement = connection.createStatement();
            // 执行 SQL 语句，并获得结果集
            set = statement.executeQuery(sql);
            // 处理结果集
            while (set.next()) {
                students.add(resultSet2Student(set));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, statement, set);
        }
        return students;
    }

    /**
     * 将结果集转换为 Student 对象
     */
    private Student resultSet2Student(ResultSet set) {
        try {
            return new Student(set.getLong("id"), set.getString("name"), set.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
