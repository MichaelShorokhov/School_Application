package com.company.controller;

import com.company.entities.Term;
import com.company.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/term")
public class TermController {
    @Autowired
    TermService service;

    @GetMapping(value = "/findAll")
    public List<Term> findAllTerms(){
        List<Term> terms = service.findAll();
        return terms;
    }

    @PostMapping(value = "/add")
    public Term addTerm(@Valid @RequestBody Term term){
        service.addTerm(term);
        return term;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeTerm(@PathVariable String id){
        service.removeTerm(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Term updateTerm(@Valid @RequestBody Term term){
        service.updateTerm(term);
        return term;
    }

    @PostMapping(value = "/close")
    public Term closeTerm(@RequestBody Term term){
        service.closeTerm(term);
        return term;
    }
}
