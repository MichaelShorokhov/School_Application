package com.company.service;

import com.company.entities.Lesson;
import com.company.entities.Mark;
import com.company.entities.MarkForLesson;
import com.company.entities.Student;
import com.company.repository.MarkForLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarkForLessonService {

    @Autowired
    private MarkForLessonRepository repository;
    @PersistenceContext
    EntityManager em;

    public List<MarkForLesson> findAll(){
        List<MarkForLesson> markForLessons = (ArrayList<MarkForLesson>)repository.findAll();
        return markForLessons.stream().sorted(Comparator.comparing(MarkForLesson::getId)).collect(Collectors.toList());
    }

    public void addMarkForLesson(MarkForLesson markForLesson){
        repository.save(markForLesson);
    }

    public MarkForLesson findMarkForLessonById(long id){
        MarkForLesson markForLesson = repository.findById(id).get();
        return markForLesson;
    }

    public void removeMarkForLesson(long id){
        repository.delete(findMarkForLessonById(id));
    }

    public void updateMarkForLesson(MarkForLesson markForLesson){
        repository.save(markForLesson);
    }
    public List<MarkForLesson> findMarkForLesson(MarkForLesson markForLesson){
        if (markForLesson.getMark()==null){markForLesson.setMark(new Mark());}
        if (markForLesson.getStudent()==null){markForLesson.setStudent(new Student());}
        if (markForLesson.getLesson()==null){markForLesson.setLesson(new Lesson());}
        Query query = em.createNativeQuery(
                "select * from mark_for_lesson "
                        + "where ((mark_id=:mark_id) or not :bymark) "
                        + "and ((student_id=:student_id) or not :bystudent) "
                        + "and ((lesson_id=:lesson_id) or not :bylesson) ", MarkForLesson.class)
                .setParameter("mark_id", markForLesson.getMark().getId())
                .setParameter("bymark", markForLesson.getMark().getId()!=0)
                .setParameter("student_id", markForLesson.getStudent().getId())
                .setParameter("bystudent", markForLesson.getStudent().getId()!=0)
                .setParameter("lesson_id", markForLesson.getLesson().getId())
                .setParameter("bylesson", markForLesson.getLesson().getId()!=0);
        List<MarkForLesson> markForLessons = query.getResultList();
        return markForLessons;
    }

}
