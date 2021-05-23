package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validation;
import javax.xml.bind.ValidationException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> selectAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) throws ValidationException {
        if (student.getName().length() > 2 && student.getName().length() > 15) {
            throw new ValidationException("The name is out of range");
        }

        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);

    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }


}
