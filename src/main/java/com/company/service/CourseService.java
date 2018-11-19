package com.company.service;

import com.company.entities.Course;
import com.company.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;
    @Autowired
    private StudyGroupService groupService;

    public List<Course> findAll(){
        List<Course> courses = (ArrayList<Course>)repository.findAll();
        return courses.stream().sorted(Comparator.comparing(Course::getId)).collect(Collectors.toList());
    }

    public void addCourse(Course course){
        repository.save(course);
    }

    public Course findCourseById(long id){
        Course course = repository.findById(id).get();
        return course;
    }
    @Transactional
    public void removeCourse(long id){
        findCourseById(id).getGroups().forEach(group -> groupService.removeStudyGroup(group.getId()));
        repository.deleteById(id);
    }

    public void updateCourse(Course course){
        repository.save(course);
    }

}
