package com.company.controller;

import com.company.entities.Course;
import com.company.entities.StudyGroup;
import com.company.entities.Subject;
import com.company.entities.Teacher;
import com.company.service.CourseService;
import com.company.service.StudyGroupService;
import com.company.service.SubjectService;
import com.company.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping(value = "/findAll")
    public List<Teacher> findAllTeachers(){
        List<Teacher> teachers = teacherService.findAll();
        return teachers;
    }

//    @GetMapping(value = "/findGroups")
//    public String findAllTeacherGroupsForm(Model model, @ModelAttribute ArrayList<StudyGroup> groups){
//        List<Teacher> teachers = teacherService.findAll();
//        model.addAttribute("teacher", new Teacher());
//        model.addAttribute("teachers", teachers);
//        return "teacher/findTeacherGroups";
//    }
//    @PostMapping(value = "/findGroups")
//    public String findAllTeacherGroups(Model model,@ModelAttribute Teacher teacher){
//        model.addAttribute("groups", teacherService.findTeacherById(teacher.getId()).getGroups());
//        return "teacher/findTeacherGroups";
//    }
//
//    @GetMapping(value = "/findSubjects")
//    public String findAllTeacherSubjectsForm(Model model, @ModelAttribute ArrayList<Subject> subjects){
//        List<Teacher> teachers = teacherService.findAll();
//        model.addAttribute("teacher", new Teacher());
//        model.addAttribute("teachers", teachers);
//        return "teacher/findTeacherSubjects";
//    }
//    @PostMapping(value = "/findSubjects")
//    public String findAllTeacherSubjects(Model model,@ModelAttribute Teacher teacher){
//        model.addAttribute("subjects", teacherService.findTeacherById(teacher.getId()).getSubjects());
//        return "teacher/findTeacherSubjects";
//    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public Teacher addTeacher(@RequestBody Teacher teacher){
        System.out.println("Teacher");
        teacherService.addTeacher(teacher);
        return teacher;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeTeacher(@PathVariable String id){
        teacherService.removeTeacher(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Teacher updateTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher);
        return teacher;
    }

//    @GetMapping(value = "/addGroup")
//    public String addTeacherToGroupForm(Model model){
//        model.addAttribute("teacher", new Teacher());
//            model.addAttribute("teachers", teacherService.findAll());
//            model.addAttribute("groups", groupService.findAll());
//        return "teacher/addGroup";
//    }

//    @PostMapping(value = "/addGroup")
//    public String addTeacherToGroup(@ModelAttribute Teacher teacher){
//        teacherService.addTeacherToGroup(teacherService.findTeacherById(teacher.getId()),
//                groupService.findStudyGroupById(teacher.getGroups().get(0).getId()));
//        return "redirect:/teacher";
//    }
//
//    @GetMapping(value = "/removeGroup")
//    public String removeTeacherFromGroupForm(Model model){
//        model.addAttribute("teacher", new Teacher());
//        model.addAttribute("teachers", teacherService.findAll());
//        model.addAttribute("groups", groupService.findAll());
//        return "teacher/removeGroup";
//    }
//
//    @PostMapping(value = "/removeGroup")
//    public String removeTeacherFromGroup(@ModelAttribute Teacher teacher){
//        teacherService.removeTeacherFromGroup(teacherService.findTeacherById(teacher.getId()),
//                groupService.findStudyGroupById(teacher.getGroups().get(0).getId()));
//        return "redirect:/teacher";
//    }
//
//    @GetMapping(value = "/addSubject")
//    public String addSubjectToTeacherForm(Model model){
//        model.addAttribute("teacher", new Teacher());
//        model.addAttribute("teachers", teacherService.findAll());
//        model.addAttribute("subjects", subjectService.findAll());
//        return "teacher/addSubject";
//    }
//
//    @PostMapping(value = "/addSubject")
//    public String addSubjectToTeacher(@ModelAttribute Teacher teacher){
//        teacherService.addSubjectToTeacher(teacherService.findTeacherById(teacher.getId()),
//                subjectService.findSubjectById(teacher.getSubjects().get(0).getId()));
//        return "redirect:/teacher";
//    }
//
//    @GetMapping(value = "/removeSubject")
//    public String removeSubjectFronTeacherForm(Model model){
//        model.addAttribute("teacher", new Teacher());
//        model.addAttribute("teachers", teacherService.findAll());
//        model.addAttribute("subjects", subjectService.findAll());
//        return "teacher/removeSubject";
//    }
//
//    @PostMapping(value = "/removeSubject")
//    public String removeSubjectFromTeacher(@ModelAttribute Teacher teacher){
//        teacherService.removeSubjectFromTeacher(teacherService.findTeacherById(teacher.getId()),
//                subjectService.findSubjectById(teacher.getSubjects().get(0).getId()));
//        return "redirect:/teacher";
//    }
}
