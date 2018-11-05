package com.company.service;

import com.company.entities.Subject;
import com.company.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    public List<Subject> findAll(){
        List<Subject> subjects = (ArrayList<Subject>)repository.findAll();
        return subjects.stream().sorted(Comparator.comparing(Subject::getId)).collect(Collectors.toList());
    }

    public void addSubject(Subject subject){
        repository.save(subject);
    }

    public Subject findSubjectById(long id){
        Subject subject = repository.findById(id).get();
        return subject;
    }

    public void removeSubject(long id){
        repository.delete(findSubjectById(id));
    }

    public void updateSubject(Subject subject){
        repository.save(subject);
    }

}
