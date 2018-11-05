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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudyGroupService groupService;
    @Autowired
    SubjectService subjectService;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", new ArrayList<Teacher>());
        model.addAttribute("groups", new ArrayList<StudyGroup>());
        model.addAttribute("subjects", new ArrayList<Subject>());
        return "teacher/teacherHomePage";
    }

    @GetMapping(value = "/find")
    public String findTeacherForm( Model model, @ModelAttribute Teacher teacher){
        model.addAttribute("teacher", new Teacher());
        return "teacher/findTeacher";
    }

    @PostMapping(value = "/find")
    public String findTeacher(Model model,@ModelAttribute Teacher teacher){
        model.addAttribute("teachers", teacherService.findTeacher(teacher));
        return "teacher/findTeacher";
    }

    @GetMapping(value = "/findAll")
    public String findAllTeachers(Model model){
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "teacher/findAllTeachers";
    }

    @GetMapping(value = "/findGroups")
    public String findAllTeacherGroupsForm(Model model, @ModelAttribute ArrayList<StudyGroup> groups){
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teachers);
        return "teacher/findTeacherGroups";
    }
    @PostMapping(value = "/findGroups")
    public String findAllTeacherGroups(Model model,@ModelAttribute Teacher teacher){
        model.addAttribute("groups", teacherService.findTeacherById(teacher.getId()).getGroups());
        return "teacher/findTeacherGroups";
    }

    @GetMapping(value = "/findSubjects")
    public String findAllTeacherSubjectsForm(Model model, @ModelAttribute ArrayList<Subject> subjects){
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teachers);
        return "teacher/findTeacherSubjects";
    }
    @PostMapping(value = "/findSubjects")
    public String findAllTeacherSubjects(Model model,@ModelAttribute Teacher teacher){
        model.addAttribute("subjects", teacherService.findTeacherById(teacher.getId()).getSubjects());
        return "teacher/findTeacherSubjects";
    }

    @GetMapping(value = "/add")
    public String addTeacherForm(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teacher/addTeacher";
    }

    @PostMapping(value = "/add")
    public String addTeacher(@Valid @ModelAttribute Teacher teacher){
        teacherService.addTeacher(teacher);
        return "redirect:/teacher";
    }

    @GetMapping(value = "/remove")
    public String removeTeacherForm(Model model){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teacherService.findAll());
        return "teacher/removeTeacher";
    }

    @PostMapping(value = "/remove")
    public String removeTeacher(@ModelAttribute Teacher teacher){
        teacherService.removeTeacher(teacher.getId());
        return "redirect:/teacher";
    }

    @GetMapping(value = "/update")
    public String updateTeacherForm(Model model){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teacherService.findAll());
        return "teacher/updateTeacher";
    }

    @PostMapping(value = "/update")
    public String updateTeacher(@Valid @ModelAttribute Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher";
    }

    @GetMapping(value = "/addGroup")
    public String addTeacherToGroupForm(Model model){
        model.addAttribute("teacher", new Teacher());
            model.addAttribute("teachers", teacherService.findAll());
            model.addAttribute("groups", groupService.findAll());
        return "teacher/addGroup";
    }

    @PostMapping(value = "/addGroup")
    public String addTeacherToGroup(@ModelAttribute Teacher teacher){
        teacherService.addTeacherToGroup(teacherService.findTeacherById(teacher.getId()),
                groupService.findStudyGroupById(teacher.getGroups().get(0).getId()));
        return "redirect:/teacher";
    }

    @GetMapping(value = "/removeGroup")
    public String removeTeacherFromGroupForm(Model model){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("groups", groupService.findAll());
        return "teacher/removeGroup";
    }

    @PostMapping(value = "/removeGroup")
    public String removeTeacherFromGroup(@ModelAttribute Teacher teacher){
        teacherService.removeTeacherFromGroup(teacherService.findTeacherById(teacher.getId()),
                groupService.findStudyGroupById(teacher.getGroups().get(0).getId()));
        return "redirect:/teacher";
    }

    @GetMapping(value = "/addSubject")
    public String addSubjectToTeacherForm(Model model){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "teacher/addSubject";
    }

    @PostMapping(value = "/addSubject")
    public String addSubjectToTeacher(@ModelAttribute Teacher teacher){
        teacherService.addSubjectToTeacher(teacherService.findTeacherById(teacher.getId()),
                subjectService.findSubjectById(teacher.getSubjects().get(0).getId()));
        return "redirect:/teacher";
    }

    @GetMapping(value = "/removeSubject")
    public String removeSubjectFronTeacherForm(Model model){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "teacher/removeSubject";
    }

    @PostMapping(value = "/removeSubject")
    public String removeSubjectFromTeacher(@ModelAttribute Teacher teacher){
        teacherService.removeSubjectFromTeacher(teacherService.findTeacherById(teacher.getId()),
                subjectService.findSubjectById(teacher.getSubjects().get(0).getId()));
        return "redirect:/teacher";
    }
}
