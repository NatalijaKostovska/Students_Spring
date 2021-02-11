package com.example.demo.Repository;

import com.example.demo.Model.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class StudentRepositoryImpl implements StudentRepository {


    private HashMap<Long, Student> students;
    private Long counter;



    @PostConstruct
    public void init() {
        this.counter = 0L;
        this.students = new HashMap<>();
        Long id = this.generateKey();
        this.students.put(id, new Student(id,"Natalija","Kostovska"));
        id = this.generateKey();
        this.students.put(id, new Student(id,"Kristijan","Kostovski"));
    }


    @Override
    public List<Student> findAll() {
        return new ArrayList<>(this.students.values());
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(this.students.get(id));
    }

    @Override
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(this.generateKey());
        }
        this.students.put(student.getId(), student);
        return student;
    }

    @Override
    public void deleteById(Long id) {
        this.students.remove(id);
    }

    private Long generateKey() {
        return ++counter;
    }
}
