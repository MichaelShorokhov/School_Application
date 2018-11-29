package com.company.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Check;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Check(constraints = "startdate < enddate")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "term_seq")
    @SequenceGenerator(name = "term_seq", sequenceName = "term_id_seq", allocationSize = 1)
    private long id;
    @NotEmpty
    private String name;
    @Column(name = "startdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date startDate;
    @Column(name = "enddate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date endDate;
    @Column(name = "isclosed")
    private boolean isClosed;
    @OneToMany(mappedBy = "term", orphanRemoval = true)
    @JsonIgnore
    private List<Lesson> lessons = new ArrayList<>();


    public Term() {
    }

    public Term(String name, Date startDate, Date endDate, boolean isClosed) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isClosed = isClosed;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void setId(long id) {
        this.id = id;
    }
}
