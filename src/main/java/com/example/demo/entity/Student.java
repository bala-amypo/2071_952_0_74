package com.example.demo.entity;

import java.time.*;

public class Student {
    private Long id;
    private String name;
    private String dept;
    private LocalDate dob;
    private float cgpa;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for dept
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    // Getter and Setter for dob
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // Getter and Setter for cgpa
    public float getCgpa() {
        return cgpa;
    }
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
}