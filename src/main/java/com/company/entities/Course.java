package com.company.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "course_id_seq", allocationSize = 1)
    private long id;
    @NotNull
    @Min(2000)
    @Max(2050)
    private int year;
    @OneToMany(mappedBy = "course", orphanRemoval = true)
    @JsonIgnore
    private List<StudyGroup> groups = new ArrayList<>();

    public long getId() {
        return id;
    }

    public Course(int year) {
        this.year = year;
    }

    public Course() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
