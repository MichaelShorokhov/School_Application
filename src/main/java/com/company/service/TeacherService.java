package com.company.service;

import com.company.entities.StudyGroup;
import com.company.entities.Subject;
import com.company.entities.Teacher;
import com.company.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public List<Teacher> findAll(){
        List<Teacher> teachers = (ArrayList<Teacher>)repository.findAll();
        return teachers.stream().sorted(Comparator.comparing(Teacher::getId)).collect(Collectors.toList());
    }

    public void addTeacher(Teacher teacher){
        repository.save(teacher);
    }

    public Teacher findTeacherById(long id){
        Teacher teacher = repository.findById(id).get();
        return teacher;
    }

    public void removeTeacher(long id){
        Teacher teacher = findTeacherById(id);
        while (!teacher.getGroups().isEmpty()){
            teacher.removeGroup(teacher.getGroups().get(0));
        }
        while (!teacher.getSubjects().isEmpty()){
            teacher.removeSubject(teacher.getSubjects().get(0));
        }
        repository.delete(teacher);
    }

    public void updateTeacher(Teacher teacher){
        repository.save(teacher);
    }

    public void addTeacherToGroup(Teacher teacher, StudyGroup group){
        teacher.addStudyGroup(group);
        repository.save(teacher);
    }

    public void removeTeacherFromGroup(Teacher teacher, StudyGroup group){
        teacher.removeGroup(group);
        repository.save(teacher);
    }

    public void addSubjectToTeacher(Teacher teacher, Subject subject){
        teacher.addSubject(subject);
        repository.save(teacher);
    }

    public void removeSubjectFromTeacher(Teacher teacher, Subject subject){
        teacher.removeSubject(subject);
        repository.save(teacher);
    }
}
