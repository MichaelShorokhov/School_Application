package com.company.controller;

import com.company.entities.Course;
import com.company.entities.Lesson;
import com.company.entities.Teacher;
import com.company.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/lesson")
public class LessonController {
    @Autowired
    LessonService lessonService;

    @GetMapping(value = "/findAll")
    public List<Lesson> findAllLessons(){
        return  lessonService.findAll();
    }


    @PostMapping(value = "/add")
    public Lesson addLesson(@RequestBody Lesson lesson){
        lessonService.addLesson(lesson);
        return lesson;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeLesson(@PathVariable String id){
        lessonService.removeLesson(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Lesson updateStudent(@Valid @RequestBody Lesson lesson){
        lessonService.updateLesson(lesson);
        return lesson;
    }
}
