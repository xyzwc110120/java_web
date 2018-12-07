package com.cyx.java_web.web_03_CRUD.dao.impl;

import com.cyx.java_web.web_03_CRUD.dao.IStudentDAO;
import com.cyx.java_web.web_03_CRUD.domain.Student;
import com.cyx.java_web.web_03_CRUD.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM student WHERE `id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }
    }

    @Override
    public void add(Student student) {
        String sql = "INSERT INTO student (`name`, age) VALUES (?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE student s SET s.`name` = ?, s.age = ? WHERE s.`id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setLong(3, student.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }
    }

    @Override
    public Student get(Long id) {
        String sql = "SELECT s.`id`, s.`name`, s.age FROM student s WHERE s.`id` = ?";
        Student student = new Student();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            set = statement.executeQuery();
            if (set.next()) {
                student = resultSet2Student(set);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, set);
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        String sql = "SELECT s.id, s.`name`, s.age FROM student s";
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;

        try {
            // 获得链接对象
            connection = JDBCUtil.getConnection();
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
            JDBCUtil.close(connection, statement, set);
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
