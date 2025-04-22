package com.aryanlanghanoja.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subject_tbl")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subject_id;

    @Column(name = "subject_name", length = 32)
    private String subject_name;

    @Column(name = "instructure", length = 128)
    private String instructure;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();

    public Subject() {
    }

    // Getters and Setters
    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getInstructure() {
        return instructure;
    }

    public void setInstructure(String instructure) {
        this.instructure = instructure;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
