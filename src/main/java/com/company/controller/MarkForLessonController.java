package com.company.controller;

import com.company.entities.MarkForLesson;
import com.company.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/marksForLesson")
public class MarkForLessonController {
    @Autowired
    MarkForLessonService markForLessonService;
    @Autowired
    LessonService lessonService;
    @Autowired
    StudentService studentService;
    @Autowired
    MarkService markService;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("markForLesson", new MarkForLesson());
        return "markForLesson/markForLessonHomePage";
    }

    @GetMapping(value = "/findAll")
    public String findAllMarkForLessons(Model model){
        model.addAttribute("markForLessons", markForLessonService.findAll());
        return "markForLesson/findAllMarksForLessons";
    }


    @GetMapping(value = "/add")
    public String addMarkForLessonForm(Model model){
        model.addAttribute("markForLesson", new MarkForLesson());
        model.addAttribute("lessons", lessonService.findAll());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("marks", markService.findAll());
        return "markForLesson/addMarkForLesson";
    }

    @PostMapping(value = "/add")
    public String addMarkForLesson(@Valid @ModelAttribute MarkForLesson markForLesson){
        markForLessonService.addMarkForLesson(markForLesson);
        return "redirect:/markForLesson";
    }

    @GetMapping(value = "/find")
    public String findMarkForLessonForm( Model model, @ModelAttribute MarkForLesson markForLesson){
        model.addAttribute("markForLesson", new MarkForLesson());
        model.addAttribute("marks", markService.findAll());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("lessons", lessonService.findAll());
        return "markForLesson/findMarkForLesson";
    }

    @PostMapping(value = "/find")
    public String findMarkForLesson(Model model,@ModelAttribute MarkForLesson markForLesson){
        model.addAttribute("markForLessons", markForLessonService.findMarkForLesson(markForLesson));
        return "markForLesson/findMarkForLesson";
    }
}
