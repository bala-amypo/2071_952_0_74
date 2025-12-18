package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE
    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.poststudent(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id,
                                @Valid @RequestBody Student student) {
        return studentService.updateData(id, student);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteData(id);
    }
}
