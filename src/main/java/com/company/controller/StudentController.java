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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/findAll")
    public List<Student> findAllStudents(){
        List<Student> students = studentService.findAll();
        return students;
    }
//
//    @GetMapping(value = "/findSubjects")
//    public String findAllStudentSubjectsForm(Model model, @ModelAttribute ArrayList<Subject> subjects){
//        List<Student> students = studentService.findAll();
//        model.addAttribute("student", new Student());
//        model.addAttribute("students", students);
//        return "student/findStudentSubjects";
//    }
//    @PostMapping(value = "/findSubjects")
//    public String findAllStudentSubjects(Model model,@ModelAttribute Student student){
//        model.addAttribute("subjects", studentService.findStudentById(student.getId()).getSubjects());
//        return "student/findStudentSubjects";
//    }

    @PostMapping(value = "/add")
    public Student addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return student;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeStudent(@PathVariable String id){
        studentService.removeStudent(Long.parseLong(id));
    }

    @PostMapping(value = "/update")
    public Student updateStudent(@Valid @RequestBody Student student){
        studentService.updateStudent(student);
        return student;
    }
//
//    @GetMapping(value = "/addSubject")
//    public String addSubjectToStudentForm(Model model){
//        model.addAttribute("student", new Student());
//        model.addAttribute("students", studentService.findAll());
//        model.addAttribute("subjects", subjectService.findAll());
//        return "student/addSubject";
//    }
//
//    @PostMapping(value = "/addSubject")
//    public String addSubjectToStudent(@ModelAttribute Student student){
//        studentService.addSubjectToStudent(studentService.findStudentById(student.getId()),
//                subjectService.findSubjectById(student.getSubjects().get(0).getId()));
//        return "redirect:/student";
//    }
//
//    @GetMapping(value = "/removeSubject")
//    public String removeSubjectFronStudentForm(Model model){
//        model.addAttribute("student", new Student());
//        model.addAttribute("students", studentService.findAll());
//        model.addAttribute("subjects", subjectService.findAll());
//        return "student/removeSubject";
//    }
//
//    @PostMapping(value = "/removeSubject")
//    public String removeSubjectFromStudent(@ModelAttribute Student student){
//        studentService.removeSubjectFromStudent(studentService.findStudentById(student.getId()),
//                subjectService.findSubjectById(student.getSubjects().get(0).getId()));
//        return "redirect:/student";
//    }
}
