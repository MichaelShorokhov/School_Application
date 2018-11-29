package com.company.controller;

import com.company.entities.Mark;
import com.company.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/findAll")
    public List<Mark> findAllMarks(){
        List<Mark> marks = service.findAll();
        return marks;
    }

    @PostMapping(value = "/add")
    public Mark addMark(@Valid @RequestBody Mark mark){
        service.addMark(mark);
        return mark;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeMark(@PathVariable String id){
        service.removeMark(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Mark updateMark(@Valid @RequestBody Mark mark){
        service.updateMark(mark);
        return mark;
    }
}
