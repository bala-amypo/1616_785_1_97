package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student addStudent(Student student) {
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return List.of();
    }

    @Override
    public Student findById(Long id) {
        // throw "Student not found" if missing
        return null;
    }
}
