package org.example.service;

import org.example.entity.Professor;
import org.example.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> selectAllProfessors() {
       // professorRepository.saveAll(professorList);
        return professorRepository.findAll();
    }

    public Professor getProfessorById(@PathVariable int id) {
        return professorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Professor addProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(@RequestBody Professor professor) {

        return professorRepository.save(professor);

    }

    public String deleteProfessorById(@PathVariable int id) {
        professorRepository.deleteById(id);
        return "The professor from id " + id + " was removed";
    }

    private static List<Professor> professorList = new ArrayList<>();

    static {
        professorList.add(new Professor(4, "Cornel", "Marian"));
        professorList.add(new Professor(5, "Iustin", "Emil"));
        professorList.add(new Professor(6, "Corneliu", "Mircea"));

    }


}
