package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 1, max = 10, message = "Name should be 1 to 10 characters")
    private String name;

    @NotBlank(message = "Department cannot be empty")
    private String dept;

    @Past(message = "DOB must be in the past")
    private LocalDate dob;

    @Min(value = 0, message = "CGPA cannot be negative")
    @Max(value = 10, message = "CGPA cannot exceed 10")
    private float cgpa;

    public Student() {}

    public Student(Long id, String name, String dept, LocalDate dob, float cgpa) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.dob = dob;
        this.cgpa = cgpa;
    }

    // 🔹 Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public float getCgpa() { return cgpa; }
    public void setCgpa(float cgpa) { this.cgpa = cgpa; }
}
