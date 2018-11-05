package com.company.controller;

import com.company.entities.Course;
import com.company.entities.Lesson;
import com.company.entities.Teacher;
import com.company.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/lesson")
public class LessonController {
    @Autowired
    LessonService lessonService;
    @Autowired
    StudyGroupService studyGroupService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    TermService termService;
    @Autowired
    TeacherService teacherService;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("lesson", new Lesson());
        return "lesson/lessonHomePage";
    }

    @GetMapping(value = "/findAll")
    public String findAllLessons(Model model){
        model.addAttribute("lessons", lessonService.findAll());
        return "lesson/findAllLessons";
    }


    @GetMapping(value = "/add")
    public String addLessonForm(Model model){
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("groups", studyGroupService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        model.addAttribute("terms", termService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        return "lesson/addLesson";
    }

    @PostMapping(value = "/add")
    public String addLesson(@Valid @ModelAttribute Lesson lesson){
        lessonService.addLesson(lesson);
        return "redirect:/lesson";
    }

    @GetMapping(value = "/find")
    public String findLessonForm( Model model, @ModelAttribute Lesson lesson){
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("groups", studyGroupService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        model.addAttribute("terms", termService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        return "lesson/findLesson";
    }

    @PostMapping(value = "/find")
    public String findLesson(Model model,@ModelAttribute Lesson lesson){
        model.addAttribute("lessons", lessonService.findLesson(lesson));
        return "lesson/findLesson";
    }
}
