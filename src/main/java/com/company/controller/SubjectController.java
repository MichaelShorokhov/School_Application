package com.company.controller;

import com.company.entities.Subject;
import com.company.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/subject")
public class SubjectController {
    @Autowired
    SubjectService service;

    @GetMapping(value = "/findAll")
    public List<Subject> findAllSubjects(){
        List<Subject> subjects = service.findAll();
        return subjects;
    }

    @PostMapping(value = "/add")
    public Subject addSubject(@Valid @RequestBody Subject subject){
        service.addSubject(subject);
        return subject;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeSubject(@PathVariable String id){
        service.removeSubject(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Subject updateSubject(@Valid @RequestBody Subject subject){
        subject.setStudents(service.findSubjectById(subject.getId()).getStudents());
        subject.setTeachers(service.findSubjectById(subject.getId()).getTeachers());
        service.updateSubject(subject);
        return subject;
    }
}
