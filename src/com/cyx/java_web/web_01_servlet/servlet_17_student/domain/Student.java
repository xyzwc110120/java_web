package com.cyx.java_web.web_01_servlet.servlet_17_student.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Student {

    public Student() {
    }

    public Student(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private Long id;
    private String name;
    private Integer age;
}
