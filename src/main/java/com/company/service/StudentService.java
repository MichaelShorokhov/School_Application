package com.company.service;

import com.company.entities.Student;
import com.company.entities.Subject;
import com.company.repository.MarkForLessonRepository;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
