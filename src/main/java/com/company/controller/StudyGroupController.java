package com.company.controller;

import com.company.entities.Course;
import com.company.entities.StudyGroup;
import com.company.service.CourseService;
import com.company.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.acl.Group;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/group")
public class StudyGroupController {
    @Autowired
    StudyGroupService groupService;
    @Autowired
    CourseService courseService;

    @GetMapping(value = "/findAll")
    public List<StudyGroup> findAllStudyGroups(){
        List<StudyGroup> groups = groupService.findAll();
        return groups;
    }

    @PostMapping(value = "/add")
    public StudyGroup addStudyGroup(@Valid @RequestBody StudyGroup group){
        group.setCourse(courseService.findCourseById(group.getCourse().getId()));
        groupService.addStudyGroup(group);
        return group;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeStudyGroup(@PathVariable String id){
        groupService.removeStudyGroup(Long.parseLong(id));
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudyGroup updateStudyGroup(@Valid @RequestBody StudyGroup group){
        groupService.updateStudyGroup(group);
        return group;
    }
}
