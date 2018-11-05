package com.company.controller;

import com.company.entities.Course;
import com.company.entities.Course;
import com.company.service.CourseService;
import com.company.service.CourseService;
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
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    CourseService service;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("course", new Course());
        return "course/courseHomePage";
    }

    @GetMapping(value = "/find")
    public String findCourseForm(@ModelAttribute Course course, Model model){
        model.addAttribute("courses", service.findAll());
        return "course/findCourse";
    }

    @PostMapping(value = "/find")
    public String findCourse(Model model, @ModelAttribute Course course){
        model.addAttribute("course", service.findCourseById(course.getId()));
        return "course/findCourse";
    }

    @GetMapping(value = "/findAll")
    public String findAllCourses(Model model){
        List<Course> courses = service.findAll();
        model.addAttribute("courses", courses);
        return "course/findAllCourses";
    }


    @GetMapping(value = "/add")
    public String addCourseForm(Model model){
        model.addAttribute("course", new Course());
        return "course/addCourse";
    }

    @PostMapping(value = "/add")
    public String addCourse(@Valid @ModelAttribute Course course){
        service.addCourse(course);
        return "redirect:/course";
    }

    @GetMapping(value = "/remove")
    public String removeCourseForm(Model model){
        model.addAttribute("course", new Course());
        model.addAttribute("courses", service.findAll());
        return "course/removeCourse";
    }

    @PostMapping(value = "/remove")
    public String removeCourse(@ModelAttribute Course course){
        service.removeCourse(course.getId());
        return "redirect:/course";
    }

    @GetMapping(value = "/update")
    public String updateCourseForm(Model model){
        model.addAttribute("course", new Course());
        model.addAttribute("courses", service.findAll());
        return "course/updateCourse";
    }

    @PostMapping(value = "/update")
    public String updateCourse(@Valid @ModelAttribute Course course){
        service.updateCourse(course);
        return "redirect:/course";
    }
}
