package com.company.controller;

import com.company.entities.Course;
import com.company.entities.Course;
import com.company.service.CourseService;
import com.company.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    CourseService service;

    @GetMapping(value = "/findAll")
    public List<Course> findAllCourses(){
        List<Course> courses = service.findAll();
        return courses;
    }

    @PostMapping(value = "/add")
    public Course addCourse(@Valid @RequestBody Course course){
        service.addCourse(course);
        return course;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeCourse(@PathVariable String id){
        service.removeCourse(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Course updateCourse(@Valid @RequestBody Course course){
        service.updateCourse(course);
        return course;
    }
}
