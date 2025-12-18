package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import jakartavalidation.constraints.*;
import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.poststudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,@Valid @RequestBody Student student){
       return studentService.updateData(id,student);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return studentService.deleteData(id);
    }
}
