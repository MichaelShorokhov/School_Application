package com.company.controller;

import com.company.entities.StudyGroup;
import com.company.service.CourseService;
import com.company.service.StudentService;
import com.company.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/group")
public class StudyGroupController {
    @Autowired
    StudyGroupService groupService;

    @GetMapping(value = "/findAll")
    public List<StudyGroup> findAllStudyGroups(){
        List<StudyGroup> groups = groupService.findAll();
        return groups;
    }

    @PostMapping(value = "/add")
    public StudyGroup addStudyGroup(@Valid @RequestBody StudyGroup group){
        groupService.addStudyGroup(group);
        return group;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeStudyGroup(@PathVariable String id){
        groupService.removeStudyGroup(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public StudyGroup updateStudyGroup(@Valid @RequestBody StudyGroup group){
        group.setTeachers(groupService.findStudyGroupById(group.getId()).getTeachers());
        groupService.updateStudyGroup(group);
        return group;
    }
}
