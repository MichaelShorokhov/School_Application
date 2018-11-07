package com.company.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_group")
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    @SequenceGenerator(name = "group_seq", sequenceName = "group_id_seq", allocationSize = 1)
    private long id;
    @NotEmpty
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="course_id")
    @NotNull
    private Course course;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="teacher_group",
                joinColumns = @JoinColumn(name="group_id"),
                inverseJoinColumns = @JoinColumn(name="teacher_id"))
    @JsonIgnore
    private List<Teacher> teachers = new ArrayList<>();

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StudyGroup() {
    }

    public StudyGroup(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void addTeacher(Teacher teacher){
        getTeachers().add(teacher);
    }

    public void removeTeacher(Teacher teacher){
        getTeachers().remove(teacher);
    }
}
