package com.example.demo.Repository;

import com.example.demo.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository {
    public List<Student>findAll();
    public Optional<Student> findById(Long id);
    public Student save(Student students);
    public void deleteById(Long id);

}

