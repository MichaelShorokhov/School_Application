package com.company.controller;

import com.company.entities.Course;
import com.company.entities.StudyGroup;
import com.company.service.CourseService;
import com.company.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.acl.Group;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/group")
public class StudyGroupController {
    @Autowired
    StudyGroupService groupService;
    @Autowired
    CourseService courseService;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("group", new StudyGroup());
        return "group/groupHomePage";
    }

    @GetMapping(value = "/find")
    public String findStudyGroupForm( Model model, @ModelAttribute StudyGroup group){
        model.addAttribute("group", new StudyGroup());
        model.addAttribute("groups", groupService.findAll());
        return "group/findStudyGroup";
    }

    @PostMapping(value = "/find")
    public String findStudyGroup(Model model,@ModelAttribute StudyGroup group){
        model.addAttribute("group", groupService.findStudyGroupById(group.getId()));
        return "group/findStudyGroup";
    }

    @GetMapping(value = "/findAll")
    public String findAllStudyGroups(Model model){
        List<StudyGroup> groups = groupService.findAll();
        model.addAttribute("groups", groups);
        return "group/findAllStudyGroups";
    }


    @GetMapping(value = "/add")
    public String addStudyGroupForm(Model model){
        model.addAttribute("group", new StudyGroup());
        model.addAttribute("courses", courseService.findAll());
        return "group/addStudyGroup";
    }

    @PostMapping(value = "/add")
    public String addStudyGroup(@Valid @ModelAttribute StudyGroup group){
        groupService.addStudyGroup(group, courseService.findCourseById(group.getCourse().getId()));
        return "redirect:/group";
    }

    @GetMapping(value = "/remove")
    public String removeStudyGroupForm(Model model){
        model.addAttribute("group", new StudyGroup(new String(), new Course()));
        model.addAttribute("groups", groupService.findAll());
        return "group/removeStudyGroup";
    }

    @PostMapping(value = "/remove")
    public String removeStudyGroup(@ModelAttribute StudyGroup group){
        groupService.removeStudyGroup(group.getId());
        return "redirect:/group";
    }

    @GetMapping(value = "/update")
    public String updateStudyGroupForm(Model model){
        model.addAttribute("group", new StudyGroup());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("courses", courseService.findAll());
        return "group/updateStudyGroup";
    }

    @PostMapping(value = "/update")
    public String updateStudyGroup(@Valid @ModelAttribute StudyGroup group){
        groupService.updateStudyGroup(group, courseService.findCourseById(group.getCourse().getId()));
        return "redirect:/group";
    }
}
