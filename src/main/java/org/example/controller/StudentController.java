package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.selectAllStudents();
    }

    @GetMapping("/{id}")
    private Student getStudentsById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping()
    private ResponseEntity <String> addStudent(@Valid @RequestBody Student student) throws ValidationException {
        return ResponseEntity.ok("Student is valid");
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable int id) {
        System.out.println("The student at the id " +id + " was removed");
        studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    private Student updateStudent(@PathVariable int id, @RequestBody Student student){
        student.setId(id);
//        student.setName(student.getName());
//        student.setSurname(student.getSurname());

        return studentService.updateStudent(student);

    }



}
