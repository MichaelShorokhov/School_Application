package com.company.service;

import com.company.entities.StudyGroup;
import com.company.repository.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudyGroupService {

    @Autowired
    private StudyGroupRepository repository;


    public List<StudyGroup> findAll(){
        List<StudyGroup> groups = (ArrayList<StudyGroup>)repository.findAll();
        return groups.stream().sorted(Comparator.comparing(StudyGroup::getId)).collect(Collectors.toList());
    }
    public void addStudyGroup(StudyGroup group){
        repository.save(group);
    }

    public StudyGroup findStudyGroupById(long id){
        StudyGroup group = repository.findById(id).get();
        return group;
    }

    public void removeStudyGroup(long id){
        repository.delete(findStudyGroupById(id));
    }

    public void updateStudyGroup(StudyGroup group){
        repository.save(group);
    }

}
