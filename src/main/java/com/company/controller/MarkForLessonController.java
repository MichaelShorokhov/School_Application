package com.company.controller;

import com.company.entities.MarkForLesson;
import com.company.service.LessonService;
import com.company.service.MarkForLessonService;
import com.company.service.MarkService;
import com.company.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/marksForLesson")
public class MarkForLessonController {
    @Autowired
    MarkForLessonService markForLessonService;

    @GetMapping(value = "/findAll")
    public List<MarkForLesson> findAllMarkForLessons(){
        return markForLessonService.findAll();
    }

    @PostMapping(value = "/add")
    public MarkForLesson addMarkForLesson(@Valid @RequestBody MarkForLesson markForLesson){
        markForLessonService.addMarkForLesson(markForLesson);
        return markForLesson;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeMarkForLesson(@PathVariable String id){
        markForLessonService.removeMarkForLesson(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public MarkForLesson updateStudent(@Valid @RequestBody MarkForLesson markForLesson){
        markForLessonService.updateMarkForLesson(markForLesson);
        return markForLesson;
    }
}
