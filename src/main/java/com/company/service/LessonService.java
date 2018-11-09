package com.company.service;

import com.company.entities.*;
import com.company.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    @Autowired
    private LessonRepository repository;
    @PersistenceContext
    EntityManager em;

    public List<Lesson> findAll(){
        List<Lesson> lessons = (ArrayList<Lesson>)repository.findAll();
        return lessons.stream().sorted(Comparator.comparing(Lesson::getId)).collect(Collectors.toList());
    }

    public void addLesson(Lesson lesson){
        repository.save(lesson);
    }

    public Lesson findLessonById(long id){
        return repository.findById(id).get();
    }

    public void removeLesson(long id){
        repository.delete(findLessonById(id));
    }

    public void updateLesson(Lesson lesson){
        repository.save(lesson);
    }

    public List<Lesson> findLesson(Lesson lesson){
        if (lesson.getTeacher()==null){lesson.setTeacher(new Teacher());}
        if (lesson.getGroup()==null){lesson.setGroup(new StudyGroup());}
        if (lesson.getSubject()==null){lesson.setSubject(new Subject());}
        if (lesson.getTerm()==null){lesson.setTerm(new Term());}
        if (lesson.getDate()==null){lesson.setDate(new Date(0));}
        Query query = em.createNativeQuery(
                "select * from lesson "
                        + "where ((date = :date) or not :bydate) "
                        + "and ((subject_id=:subject_id) or not :bysubject) "
                        + "and ((term_id=:term_id) or not :byterm) "
                        + "and ((group_id=:group_id) or not :bygroup) "
                        + "and ((teacher_id=:teacher_id) or not :byteacher) ", Lesson.class)
                .setParameter("date",  lesson.getDate())
                .setParameter("bydate", !lesson.getDate().equals(new Date(0)))
                .setParameter("subject_id", lesson.getSubject().getId())
                .setParameter("bysubject", lesson.getSubject().getId()!=0)
                .setParameter("term_id", lesson.getTerm().getId())
                .setParameter("byterm", lesson.getTerm().getId()!=0)
                .setParameter("group_id", lesson.getGroup().getId())
                .setParameter("bygroup", lesson.getGroup().getId()!=0)
                .setParameter("teacher_id", lesson.getTeacher().getId())
                .setParameter("byteacher", lesson.getTeacher().getId()!=0);
        List<Lesson> lessons = query.getResultList();
        return lessons;
    }

}
