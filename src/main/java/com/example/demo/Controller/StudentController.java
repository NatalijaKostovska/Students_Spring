package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;


   public StudentController(StudentService studentService){
       this.studentService = studentService;
   }

    @GetMapping("/{id}")
    public Student getStudentId(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping
    public List<Student> getAllStudents(){
       return studentService.findAll();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }


    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        this.studentService.deleteById(id);
        return "redirect:/students";
    }

}
