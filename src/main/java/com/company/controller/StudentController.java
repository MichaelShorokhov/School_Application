package com.company.controller;

import com.company.entities.Course;
import com.company.entities.StudyGroup;
import com.company.entities.Subject;
import com.company.entities.Student;
import com.company.service.StudyGroupService;
import com.company.service.SubjectService;
import com.company.service.StudentService;
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
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    StudyGroupService groupService;

    @GetMapping (value = "")
    public String startPage(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", new ArrayList<Student>());
        model.addAttribute("subjects", new ArrayList<Subject>());
        return "student/studentHomePage";
    }

    @GetMapping(value = "/find")
    public String findStudentForm( Model model, @ModelAttribute Student student){
        model.addAttribute("student", new Student());
        return "student/findStudent";
    }

    @PostMapping(value = "/find")
    public String findStudent(Model model,@ModelAttribute Student student){
        model.addAttribute("students", studentService.findStudent(student));
        return "student/findStudent";
    }

    @GetMapping(value = "/findAll")
    public String findAllStudents(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/findAllStudents";
    }

    @GetMapping(value = "/findSubjects")
    public String findAllStudentSubjectsForm(Model model, @ModelAttribute ArrayList<Subject> subjects){
        List<Student> students = studentService.findAll();
        model.addAttribute("student", new Student());
        model.addAttribute("students", students);
        return "student/findStudentSubjects";
    }
    @PostMapping(value = "/findSubjects")
    public String findAllStudentSubjects(Model model,@ModelAttribute Student student){
        model.addAttribute("subjects", studentService.findStudentById(student.getId()).getSubjects());
        return "student/findStudentSubjects";
    }

    @GetMapping(value = "/add")
    public String addStudentForm(@Valid Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("groups", groupService.findAll());
        return "student/addStudent";
    }

    @PostMapping(value = "/add")
    public String addStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/student";
    }

    @GetMapping(value = "/remove")
    public String removeStudentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        return "student/removeStudent";
    }

    @PostMapping(value = "/remove")
    public String removeStudent(@ModelAttribute Student student){
        studentService.removeStudent(student.getId());
        return "redirect:/student";
    }

    @GetMapping(value = "/update")
    public String updateStudentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("groups", groupService.findAll());
        return "student/updateStudent";
    }

    @PostMapping(value = "/update")
    public String updateStudent(@Valid @ModelAttribute Student student){
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @GetMapping(value = "/addSubject")
    public String addSubjectToStudentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "student/addSubject";
    }

    @PostMapping(value = "/addSubject")
    public String addSubjectToStudent(@ModelAttribute Student student){
        studentService.addSubjectToStudent(studentService.findStudentById(student.getId()),
                subjectService.findSubjectById(student.getSubjects().get(0).getId()));
        return "redirect:/student";
    }

    @GetMapping(value = "/removeSubject")
    public String removeSubjectFronStudentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "student/removeSubject";
    }

    @PostMapping(value = "/removeSubject")
    public String removeSubjectFromStudent(@ModelAttribute Student student){
        studentService.removeSubjectFromStudent(studentService.findStudentById(student.getId()),
                subjectService.findSubjectById(student.getSubjects().get(0).getId()));
        return "redirect:/student";
    }
}
