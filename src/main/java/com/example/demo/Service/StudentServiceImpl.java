package com.example.demo.Service;

import com.example.demo.Exceptions.StudentNotFoundException;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }



    @Override
    public void deleteById(Long id) {
        this.studentRepository.deleteById(id);
    }
}
