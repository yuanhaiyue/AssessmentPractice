package com.yuan.demo.controller;


import com.yuan.demo.entity.Course;
import com.yuan.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/course")
@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/select")
    public List<Course> select(){
        return courseRepository.findAll();
    }


}
