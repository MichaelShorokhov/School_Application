package com.company.controller;

import com.company.entities.MarkForLesson;
import com.company.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/marksForLesson")
public class MarkForLessonController {
    @Autowired
    MarkForLessonService markForLessonService;
    @Autowired
    MarkService markService;
    @Autowired
    LessonService lessonService;
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/findAll")
    public List<MarkForLesson> findAllMarkForLessons(){
        return markForLessonService.findAll();
    }

    @PostMapping(value = "/add")
    public MarkForLesson addMarkForLesson(@Valid @RequestBody MarkForLesson markForLesson){
        markForLesson.setMark(markService.findMarkById(markForLesson.getMark().getId()));
        markForLesson.setLesson(lessonService.findLessonById(markForLesson.getLesson().getId()));
        markForLesson.setStudent(studentService.findStudentById(markForLesson.getStudent().getId()));
        markForLessonService.addMarkForLesson(markForLesson);
        return markForLesson;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeMarkForLesson(@PathVariable String id){
        markForLessonService.removeMarkForLesson(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public MarkForLesson updateStudent(@Valid @RequestBody MarkForLesson markForLesson){
        markForLesson.setMark(markService.findMarkById(markForLesson.getMark().getId()));
        markForLesson.setLesson(lessonService.findLessonById(markForLesson.getLesson().getId()));
        markForLesson.setStudent(studentService.findStudentById(markForLesson.getStudent().getId()));
        markForLessonService.updateMarkForLesson(markForLesson);
        return markForLesson;
    }
}
