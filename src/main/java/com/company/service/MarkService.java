package com.company.service;

import com.company.entities.Mark;
import com.company.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarkService {

    @Autowired
    private MarkRepository repository;

    public List<Mark> findAll(){
        List<Mark> marks = (ArrayList<Mark>)repository.findAll();
        return marks.stream().sorted(Comparator.comparing(Mark::getId)).collect(Collectors.toList());
    }

    public void addMark(Mark mark){
        repository.save(mark);
    }

    public Mark findMarkById(long id){
        Mark mark = repository.findById(id).get();
        return mark;
    }

    public void removeMark(long id){
        repository.delete(findMarkById(id));
    }

    public void updateMark(Mark mark){
        repository.save(mark);
    }

}
