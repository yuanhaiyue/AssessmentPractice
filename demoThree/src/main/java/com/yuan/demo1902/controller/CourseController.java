package com.yuan.demo1902.controller;


import com.yuan.demo1902.entity.Course;
import com.yuan.demo1902.repository.CourseRepository;
import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    //按照id删除课程
    @PostMapping("/deleteCourse")
    public void deleteCourse(Integer id){
        courseRepository.deleteById(id);
    }
    //添加课程
    @PostMapping("/addCourse")
    public String addCourse(@Validated(Add.class)Course course){
        Course course1=courseRepository.save(course);
        return course1!=null?"success":"fail";
    }
    //更改课程
    @PostMapping("/updateCourse")
    public String updateCourse(@Validated(Update.class)Course course){
        Course course1=courseRepository.save(course);
        return course1!=null?"success":"fail";
    }


}
