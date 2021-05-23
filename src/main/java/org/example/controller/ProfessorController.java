package org.example.controller;

import org.example.entity.Professor;
import org.example.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping()
    private List<Professor> professorsList(){
        return professorService.selectAllProfessors();
    }
    @GetMapping("/{id}")
    private Professor getProfessorById(@PathVariable int id){
        return professorService.getProfessorById(id);

    }
    @PostMapping
    private Professor addProfessor(@RequestBody Professor professor){
        return professorService.addProfessor(professor);
    }

    @PutMapping("/{id}")
    private Professor updateProfessor(@RequestBody Professor professor, @PathVariable int id){
        professor.setId(id);
        return professorService.updateProfessor(professor);
    }
    @DeleteMapping("/{id}")
    private String deleteProfessorById(@PathVariable int id){
        professorService.deleteProfessorById(id);
        return "The professor from id " + id+ " was removed";
    }



}

