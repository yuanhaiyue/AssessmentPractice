package com.yuan.demo1902.controller;


import com.yuan.demo1902.entity.Course;
import com.yuan.demo1902.entity.CourseSelection;
import com.yuan.demo1902.entity.CourseStudent;
import com.yuan.demo1902.repository.CourseRepository;
import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    //根据课程名称模糊查询课程的接口
    @PostMapping("/getCourse")
    public List<Course> getCourse(String name){
        return courseRepository.findByName(name);
    }
    //根据学分区间查询课程的接口，分页查询并按学分升序排序
    @GetMapping("/getCourseCredit")
    public List<Course> getCourse(Double minC,Double maxC){
        Sort sort=Sort.by(Sort.Direction.ASC,"credit");
        return courseRepository.findByCreditBetween(minC,maxC,sort);
    }
//    根据课程名称查询选修该课程的学生的接口，
//     输出学生的（编号，姓名，性别，系部）字段，
//     分页查询并按学生编号升序排序。
    @GetMapping("/getCourseStudent")
    public List<CourseStudent> getCourseStudent(String name){

        Sort sort=Sort.by(Sort.Direction.ASC,"code");
        Pageable pageable= PageRequest.of(0, 5,sort);
        return courseRepository.getCourse(name,pageable).getContent();
    }
//    根据课程名称查询选修该课程的选课信息的接口，
//     输出学生编号，姓名，性别，系部，选课时间，成绩，
//     分页查询并按学生编号升序排序。
//    @GetMapping("/getCourseSelection")
//    public List<CourseSelection> getCourseSelect(String name){
//        Sort sort=Sort.by(Sort.Direction.ASC,"code");
//        Pageable pageable=PageRequest.of(0, 5,sort);
//        return courseRepository.getAchievement(name, pageable).getContent();
//    }
}
