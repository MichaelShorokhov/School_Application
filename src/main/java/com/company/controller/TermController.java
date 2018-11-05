package com.company.controller;

import com.company.entities.Term;
import com.company.service.TermService;
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
@RequestMapping(value = "/term")
public class TermController {
    @Autowired
    TermService service;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("term", new Term());
        return "term/termHomePage";
    }

    @GetMapping(value = "/find")
    public String findTermForm(@ModelAttribute Term term, Model model){
        model.addAttribute("terms", service.findAll());
        return "term/findTerm";
    }

    @PostMapping(value = "/find")
    public String findTerm(Model model,@ModelAttribute Term term){
        model.addAttribute("term", service.findTermById(term.getId()));
        return "term/findTerm";
    }

    @GetMapping(value = "/findAll")
    public String findAllTerms(Model model){
        List<Term> terms = service.findAll();
        model.addAttribute("terms", terms);
        return "term/findAllTerms";
    }


    @GetMapping(value = "/add")
    public String addTermForm(Model model){
        model.addAttribute("term", new Term());
        return "term/addTerm";
    }

    @PostMapping(value = "/add")
    public String addTerm(@Valid @ModelAttribute Term term){
        service.addTerm(term);
        return "redirect:/term";
    }

    @GetMapping(value = "/remove")
    public String removeTermForm(Model model){
        model.addAttribute("term", new Term());
        model.addAttribute("terms", service.findAll());
        return "term/removeTerm";
    }

    @PostMapping(value = "/remove")
    public String removeTerm(@ModelAttribute Term term){
        service.removeTerm(term.getId());
        return "redirect:/term";
    }

    @GetMapping(value = "/update")
    public String updateTermForm(Model model){
        model.addAttribute("term", new Term());
        model.addAttribute("terms", service.findAll());
        return "term/updateTerm";
    }

    @PostMapping(value = "/update")
    public String updateTerm(@Valid @ModelAttribute Term term){
        service.updateTerm(term);
        return "redirect:/term";
    }

    @GetMapping(value = "/close")
    public String closeTermForm(Model model){
        model.addAttribute("term", new Term());
        model.addAttribute("terms", service.findAll());
        return "term/setClosed";
    }

    @PostMapping(value = "/close")
    public String closeTerm(@ModelAttribute Term term){
        service.closeTerm(term);
        return "redirect:/term";
    }
}
