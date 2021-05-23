package org.example.service;

import org.example.entity.Subject;
import org.example.repository.StudentRepository;
import org.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;


    public List<Subject> subjectList() {
        return subjectRepository.findAll();
    }

    public Subject getAllSubjectsById(int id) {
        return subjectRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Subject addSubjects(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public boolean deleteSubjectById(int id) {
        subjectRepository.deleteById(id);
        return true;
    }


}
