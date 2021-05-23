package org.example.controller;

import org.example.entity.Grade;
import org.example.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    private List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    private Grade getGradesById(@PathVariable int id) {
        return gradeService.getGradesById(id);
    }

    @PostMapping
    private Grade addGrade(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    @PutMapping
    private Grade update(@RequestBody Grade grade, @PathVariable int id) {
        grade.setId(id);
        return gradeService.addGrade(grade);
    }

    @DeleteMapping("/{id}")
    private String deleteGradeById(@PathVariable int id) {
        gradeService.deleteGradeById(id);
        return "The grade at the id " + id + " was removed";
    }


}
