package com.example.demo.Service;

import com.example.demo.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student>findAll();
    Student findById(Long id);
    Student save(Student student);
    void deleteById(Long id);
}
