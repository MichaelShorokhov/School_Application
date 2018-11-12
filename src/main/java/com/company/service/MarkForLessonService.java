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

}
