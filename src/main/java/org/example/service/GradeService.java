package org.example.service;

import org.example.entity.Grade;
import org.example.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradesById(int id) {
        return gradeRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);

    }

    public String deleteGradeById(int id) {
        gradeRepository.deleteById(id);
        return "Grade from id " + id + " was removed";
    }

    public Grade updateById(Grade grade) {
        return gradeRepository.save(grade);

    }


}
