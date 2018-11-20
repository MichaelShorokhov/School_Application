package com.company.service;

import com.company.entities.Student;
import com.company.entities.Subject;
import com.company.repository.MarkForLessonRepository;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PreRemove;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private MarkForLessonRepository markForLessonRepository;
    @PersistenceContext
    EntityManager em;

    public List<Student> findAll(){
        List<Student> students = (ArrayList<Student>)repository.findAll();
        return students.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
    }

    public void addStudent(Student student){
        repository.save(student);
    }

    public Student findStudentById(long id){
        Student student = repository.findById(id).get();
        return student;
    }

    public void removeStudent(long id){
        markForLessonRepository.deleteByStudent(findStudentById(id));
//        repository.delete(findStudentById(id));
        repository.deleteById(id);
    }

    public void updateStudent(Student student){
        repository.save(student);
    }

    public void addSubjectToStudent(Student student, Subject subject){
        student.addSubject(subject);
        repository.save(student);
    }

    public void removeSubjectFromStudent(Student student, Subject subject){
        student.removeSubject(subject);
        repository.save(student);
    }
    public Student findStudentByName(String name){
        Query query = em.createNativeQuery("select * from student WHERE name=:name", Student.class)
                .setParameter("name", name);
        Student student = (Student) query.getResultList().get(0);
        return student;
    }

    public List<Student> findStudent(Student student){
        Query query = em.createNativeQuery(
                "select * from student "
                        + "where ((name=:name) or not :byname) "
                        + "and ((surname=:surname) or not :bysurname) "
                        + "and ((age=:age) or not :byage) "
                        + "and ((phone_number=:phonenumber) or not :byphonenumber) ", Student.class)
                .setParameter("name", student.getName())
                .setParameter("byname", !student.getName().isEmpty())
                .setParameter("surname", student.getSurname())
                .setParameter("bysurname", !student.getSurname().isEmpty())
                .setParameter("age", student.getAge())
                .setParameter("byage", student.getAge()!=0)
                .setParameter("phonenumber", student.getPhoneNumber())
                .setParameter("byphonenumber", !student.getPhoneNumber().isEmpty());
        List<Student> students = query.getResultList();
        return students;
    }

}
