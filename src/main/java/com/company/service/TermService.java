package com.company.service;

import com.company.entities.Term;
import com.company.repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TermService {

    @Autowired
    private TermRepository repository;

    public List<Term> findAll(){
        List<Term> terms = (ArrayList<Term>)repository.findAll();
        return terms.stream().sorted(Comparator.comparing(Term::getId)).collect(Collectors.toList());
    }

    public void addTerm(Term term){
        repository.save(term);
    }

    public Term findTermById(long id){
        Term term = repository.findById(id).get();
        return term;
    }

    public void removeTerm(long id){
        repository.delete(findTermById(id));
    }

    public void updateTerm(Term term){
        repository.save(term);
    }

    public void closeTerm(Term term){
        Term newTerm = findTermById(term.getId());
        if (!newTerm.isClosed()){
            newTerm.setClosed(true);
            repository.save(newTerm);
        }
    }

}
