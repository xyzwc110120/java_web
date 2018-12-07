package com.cyx.java_web.web_03_CRUD.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Student {

    public Student() {
    }
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
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
