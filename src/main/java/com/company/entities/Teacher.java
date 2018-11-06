package com.company.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    @SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_id_seq", allocationSize = 1)
    private long id;
//    @NotEmpty
    private String name;
//    @NotEmpty
    private String surname;
//    @NotNull
    @Max(100)
    private int age;
//    @NotEmpty
//    @Pattern(regexp = "(^$[0-9]{10})")
    private String phoneNumber;

    @JsonManagedReference
    @ManyToMany(mappedBy = "teachers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Subject> subjects = new ArrayList<>();

    @JsonManagedReference
    @ManyToMany(mappedBy = "teachers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<StudyGroup> groups = new ArrayList<>();

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<StudyGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<StudyGroup> groups) {
        this.groups = groups;
    }

    public Teacher() {

    }

    public long getId() {
        return id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public void addStudyGroup(StudyGroup group){
//        group.addTeacher(this);
//        getGroups().add(group);
//    }
//
//    public void removeGroup(StudyGroup group){
//        group.removeTeacher(this);
//        getGroups().remove(group);
//    }
//
//    public void addSubject(Subject subject){
//        subject.getTeachers().add(this);
//        getSubjects().add(subject);
//    }
//
//    public void removeSubject(Subject subject){
//        subject.getTeachers().remove(this);
//        getSubjects().remove(subject);
//    }
}
