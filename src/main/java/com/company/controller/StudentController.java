package com.company.controller;

import com.company.entities.Course;
import com.company.entities.StudyGroup;
import com.company.entities.Subject;
import com.company.entities.Student;
import com.company.service.StudyGroupService;
import com.company.service.SubjectService;
import com.company.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudyGroupService groupService;
    @Autowired
    SubjectService subjectService;

    @GetMapping(value = "/findAll")
    public List<Student> findAllStudents(){
        List<Student> students = studentService.findAll();
        return students;
    }
    @PostMapping(value = "/findSubjects")
    public List<Subject> findAllStudentSubjects(@RequestBody Student student){
        return studentService.findStudentById(student.getId()).getSubjects();
    }

    @PostMapping(value = "/add")
    public Student addStudent(@Valid @RequestBody Student student){
        student.setGroup(groupService.findStudyGroupById(student.getGroup().getId()));
        studentService.addStudent(student);
        return student;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeStudent(@PathVariable String id){
        studentService.removeStudent(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Student updateStudent(@Valid @RequestBody Student student){
        studentService.updateStudent(student);
        return student;
    }

    @PostMapping(value = "/addSubject/{id}")
    public Subject addSubjectToStudent(@PathVariable String id, @RequestBody Subject subject){
        Subject newSubject = subjectService.findSubjectById(subject.getId());
        studentService.addSubjectToStudent(studentService.findStudentById(Long.parseLong(id)),
                newSubject);
        return newSubject;
    }

    @PostMapping(value = "/removeSubject/{id}")
    public void removeSubjectFromStudent(@PathVariable String  id, @RequestBody Subject subject){
        studentService.removeSubjectFromStudent(studentService.findStudentById(Long.parseLong(id)),
                subjectService.findSubjectById(subject.getId()));
    }
}
