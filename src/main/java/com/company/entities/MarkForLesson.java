package com.company.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mark_for_lesson")
public class MarkForLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mark4lesson_seq")
    @SequenceGenerator(name = "mark4lesson_seq", sequenceName = "mark4lesson_id_seq", allocationSize = 1)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_id")
    @NotNull
    private Mark mark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    @NotNull
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @NotNull
    private Student student;

    public MarkForLesson() {
    }

    public MarkForLesson(Mark mark, Lesson lesson, Student student) {
        this.mark = mark;
        this.lesson = lesson;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setId(long id) {
        this.id = id;
    }
}
