package org.example.entity;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    @Size(min = 2, max = 30)
    private String surname;

    @ManyToMany
    private List<Subject> subjectList ;

    public Student(int idStudent, String name, String surname) {
        this.id = idStudent;
        this.name = name;
        this.surname = surname;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
