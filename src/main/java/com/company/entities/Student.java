package com.company.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_id_seq", allocationSize = 1)
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotNull
    @Max(100)
    private int age;
    @NotEmpty
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private StudyGroup group;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<MarkForLesson> marksForLessons = new ArrayList<>();

    @ManyToMany(mappedBy = "students",  cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Subject> subjects = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public StudyGroup getGroup() {
        return group;
    }

    public void setGroup(StudyGroup group) {
        this.group = group;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject){
        subject.getStudents().add(this);
        getSubjects().add(subject);
    }

    public void removeSubject(Subject subject){
        subject.getStudents().remove(this);
        getSubjects().remove(subject);
    }
}
