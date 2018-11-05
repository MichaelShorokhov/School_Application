package com.company.controller;

import com.company.entities.Subject;
import com.company.service.SubjectService;
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
@RequestMapping(value = "/subject")
public class SubjectController {
    @Autowired
    SubjectService service;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("subject", new Subject());
        return "subject/subjectHomePage";
    }

    @GetMapping(value = "/find")
    public String findSubjectForm(@ModelAttribute Subject subject, Model model) {
        model.addAttribute("subjects", service.findAll());
        return "subject/findSubject";
    }

    @PostMapping(value = "/find")
    public String findSubject(Model model,@ModelAttribute Subject subject){
        model.addAttribute("subject", service.findSubjectById(subject.getId()));
        return "subject/findSubject";
    }

    @GetMapping(value = "/findAll")
    public String findAllSubjects(Model model){
        List<Subject> subjects = service.findAll();
        model.addAttribute("subjects", subjects);
        return "subject/findAllSubjects";
    }


    @GetMapping(value = "/add")
    public String addSubjectForm(Model model){
        model.addAttribute("subject", new Subject());
        return "subject/addSubject";
    }

    @PostMapping(value = "/add")
    public String addSubject(@Valid @ModelAttribute Subject subject){
        service.addSubject(subject);
        return "redirect:/subject";
    }

    @GetMapping(value = "/remove")
    public String removeSubjectForm(Model model){
        model.addAttribute("subject", new Subject());
        model.addAttribute("subjects", service.findAll());
        return "subject/removeSubject";
    }

    @PostMapping(value = "/remove")
    public String removeSubject(@ModelAttribute Subject subject){
        service.removeSubject(subject.getId());
        return "redirect:/subject";
    }

    @GetMapping(value = "/update")
    public String updateSubjectForm(Model model){
        model.addAttribute("subject", new Subject());
        model.addAttribute("subjects", service.findAll());
        return "subject/updateSubject";
    }

    @PostMapping(value = "/update")
    public String updateSubject(@Valid @ModelAttribute Subject subject){
        service.updateSubject(subject);
        return "redirect:/subject";
    }
}
