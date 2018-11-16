package com.company.controller;

import com.company.entities.StudyGroup;
import com.company.entities.Subject;
import com.company.entities.Teacher;
import com.company.service.StudyGroupService;
import com.company.service.SubjectService;
import com.company.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    StudyGroupService groupService;

    @GetMapping(value = "/findAll")
    public List<Teacher> findAllTeachers(){
        List<Teacher> teachers = teacherService.findAll();
        return teachers;
    }

    @PostMapping(value = "/findGroups")
    public List<StudyGroup> findAllTeacherGroups(@RequestBody  Teacher teacher){
        return teacherService.findTeacherById(teacher.getId()).getGroups();
    }

    @PostMapping(value = "/findSubjects")
    public List<Subject> findAllTeacherSubjects(@RequestBody Teacher teacher){

        return teacherService.findTeacherById(teacher.getId()).getSubjects();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public Teacher addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return teacher;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeTeacher(@PathVariable String id){
        teacherService.removeTeacher(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Teacher updateTeacher(@Valid @RequestBody Teacher teacher){
        teacher.setGroups(teacherService.findTeacherById(teacher.getId()).getGroups());
        teacher.setSubjects(teacherService.findTeacherById(teacher.getId()).getSubjects());
        teacherService.updateTeacher(teacher);
        return teacher;
    }

    @PostMapping(value = "/addGroup/{id}")
    public StudyGroup addTeacherToGroup(@PathVariable String id, @RequestBody StudyGroup group){
        StudyGroup newGroup = groupService.findStudyGroupById(group.getId());
        teacherService.addTeacherToGroup(teacherService.findTeacherById(Long.parseLong(id)), newGroup);
        return newGroup;
    }

    @PostMapping(value = "/removeGroup/{id}")
    public void removeTeacherFromGroup(@PathVariable String id, @RequestBody StudyGroup group){
        teacherService.removeTeacherFromGroup(teacherService.findTeacherById(Long.parseLong(id)),
                groupService.findStudyGroupById(group.getId()));
    }

    @PostMapping(value = "/addSubject/{id}")
    public Subject addSubjectToTeacher(@PathVariable String id,@RequestBody Subject subject){
        Subject newSubject = subjectService.findSubjectById(subject.getId());
        teacherService.addSubjectToTeacher(teacherService.findTeacherById(Long.parseLong(id)), newSubject);
        return newSubject;
    }

    @PostMapping(value = "/removeSubject/{id}")
    public void removeSubjectFromTeacher(@PathVariable String id,@RequestBody Subject subject){
        teacherService.removeSubjectFromTeacher(teacherService.findTeacherById(Long.parseLong(id)),
                subjectService.findSubjectById(subject.getId()));
    }
}
