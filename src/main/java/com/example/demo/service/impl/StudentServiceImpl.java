package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdrepo;

    @Override
    public Student poststudent(Student student) {
        return stdrepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return stdrepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return stdrepo.findById(id);
    }

    @Override
    public String updateData(Long id, Student student) {
        Optional<Student> existing = stdrepo.findById(id);

        if (existing.isPresent()) {
            Student s = existing.get();
            s.setName(student.getName());
            s.setDept(student.getDept());
            s.setDob(student.getDob());
            s.setCgpa(student.getCgpa());
            stdrepo.save(s);
            return "Student updated successfully";
        }
        return "Student not found";
    }

    @Override
    public String deleteData(Long id) {
        if (stdrepo.existsById(id)) {
            stdrepo.deleteById(id);
            return "Student deleted successfully";
        }
        return "Student not found";
    }
}
