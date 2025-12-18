package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import java.util.List;
import java.util.Optional;

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
    public String updateData(Long id,Student student){
       boolean status=stdrepo.existsById(id);
       if(status){
              student.setId(id);
              stdrepo.save(student);
              return "Student updated successfully";
       }
       else{
              return "Student with ID "+id+" not found";
       }
    }
    @Override
    public String deleteData(Long id){
        boolean status=stdrepo.existsById(id);  
        if(status){
            stdrepo.deleteById(id);
            return "Student Deleted Successfully";
        }
        else{
          return "Student Not Found";
        }
    }
}
