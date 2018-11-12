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

}
