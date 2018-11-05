package com.company.controller;

import com.company.entities.Mark;
import com.company.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/mark")
    public class MarkController {
    @Autowired
    MarkService service;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("mark", new Mark());
        return "mark/markHomePage";
    }

    @GetMapping(value = "/find")
    public String findMarkForm(@ModelAttribute Mark mark, Model model) {
        model.addAttribute("marks", service.findAll());
        return "mark/findMark";
    }

    @PostMapping(value = "/find")
    public String findMark(Model model,@ModelAttribute Mark mark){
        model.addAttribute("mark", service.findMarkById(mark.getId()));
        return "mark/findMark";
    }

//    @GetMapping(value = "/findAll")
//    public String findAllMarks(Model model){
//        List<Mark> marks = service.findAll();
//        model.addAttribute("marks", marks);
//        return "mark/findAllMarks";
//    }
    @GetMapping(value = "/findAll")
    public List<Mark> findAllMarks(){
        List<Mark> marks = service.findAll();
        return marks;
    }


    @GetMapping(value = "/add")
    public String addMarkForm(Model model){
        model.addAttribute("mark", new Mark());
        return "mark/addMark";
    }

    @PostMapping(value = "/add")
    public Mark addMark(@Valid @RequestBody Mark mark, BindingResult bindingResult){
        service.addMark(mark);
        return mark;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeMark(@PathVariable String id){
        service.removeMark(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Mark updateMark(@Valid @RequestBody Mark mark, BindingResult bindingResult){
        service.updateMark(mark);
        return mark;
    }
}
