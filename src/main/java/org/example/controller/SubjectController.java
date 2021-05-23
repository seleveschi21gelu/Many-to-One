package org.example.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.example.entity.Subject;
import org.example.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    private List<Subject> getAllSubjects() {
        return subjectService.subjectList();
    }

    @GetMapping("/{id}")
    private Subject getSubjectsById(@PathVariable int id) {
        return subjectService.getAllSubjectsById(id);
    }

    @PostMapping
    private Subject addSubject(@RequestBody Subject subject) {
        return subjectService.addSubjects(subject);
    }

    @PutMapping("/{id}")
    private Subject updateSubjectById(@RequestBody Subject subject) {
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping("/{id}")
    private boolean deleteSubjectById(@PathVariable int id) {
        subjectService.deleteSubjectById(id);
        return true;
    }

}
