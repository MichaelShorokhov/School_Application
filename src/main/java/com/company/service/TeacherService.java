package com.company.service;

import com.company.entities.StudyGroup;
import com.company.entities.Subject;
import com.company.entities.Teacher;
import com.company.repository.SubjectRepository;
import com.company.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.security.acl.Group;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Scope(value = "prototype")
public class TeacherService {

    @Autowired
    private TeacherRepository repository;
    @PersistenceContext
    EntityManager em;

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
//        while (!teacher.getGroups().isEmpty()){
//            teacher.removeGroup(teacher.getGroups().get(0));
//        }
//        while (!teacher.getSubjects().isEmpty()){
//            teacher.removeSubject(teacher.getSubjects().get(0));
//        }
        repository.delete(teacher);
    }

    public void updateTeacher(Teacher teacher){
        repository.save(teacher);
    }

//    public void addTeacherToGroup(Teacher teacher, StudyGroup group){
//        teacher.addStudyGroup(group);
//        repository.save(teacher);
//    }
//
//    public void removeTeacherFromGroup(Teacher teacher, StudyGroup group){
//        teacher.removeGroup(group);
//        repository.save(teacher);
//    }
//
//    public void addSubjectToTeacher(Teacher teacher, Subject subject){
//        teacher.addSubject(subject);
//        repository.save(teacher);
//    }
//
//    public void removeSubjectFromTeacher(Teacher teacher, Subject subject){
//        teacher.removeSubject(subject);
//        repository.save(teacher);
//    }
    public Teacher findTeacherByName(String name){
        Query query = em.createNativeQuery("select * from teacher WHERE name=:name", Teacher.class)
                .setParameter("name", name);
        System.out.println(query.getResultList().isEmpty());
        Teacher teacher = (Teacher)query.getResultList().get(0);
        return teacher;
    }
    @Transactional
    public List<Teacher> findTeacher(Teacher teacher){
        Query query = em.createNativeQuery(
                "select * from teacher "
                + "where ((name=:name) or not :byname) "
                + "and ((surname=:surname) or not :bysurname) "
                + "and ((age=:age) or not :byage) "
                + "and ((phone_number=:phonenumber) or not :byphonenumber) ", Teacher.class)
                .setParameter("name", teacher.getName())
                .setParameter("byname", !teacher.getName().isEmpty())
                .setParameter("surname", teacher.getSurname())
                .setParameter("bysurname", !teacher.getSurname().isEmpty())
                .setParameter("age", teacher.getAge())
                .setParameter("byage", teacher.getAge()!=0)
                .setParameter("phonenumber", teacher.getPhoneNumber())
                .setParameter("byphonenumber", !teacher.getPhoneNumber().isEmpty());
        List<Teacher> teachers = query.getResultList();
        return teachers;
    }


}
