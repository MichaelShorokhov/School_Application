package com.company.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mark")
public class Mark{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mark_seq")
    @SequenceGenerator(name = "mark_seq", sequenceName = "mark_id_seq", allocationSize = 1)
    private long id;
    @NotEmpty
    private String value;
    @OneToMany(mappedBy = "mark", orphanRemoval = true)
    @JsonIgnore
    private List<MarkForLesson> marksForLessons = new ArrayList<>();

    public void setId(long id) {
        this.id = id;
    }

    public Mark() {
    }

    public Mark(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
