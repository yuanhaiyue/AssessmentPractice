package com.yuan.demo1902.controller;


import com.yuan.demo1902.entity.Course;
import com.yuan.demo1902.entity.StudentCourse;
import com.yuan.demo1902.repository.StudentCourseRepository;
import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCourseController {

    final StudentCourseRepository studentCourseRepository;


    public StudentCourseController(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    //按照id删除选课信息
    @PostMapping("/deleteStudentCourse")
    public void deleteCourse(Integer id){
        studentCourseRepository.deleteById(id);
    }
    //添加选课信息
    @PostMapping("/addStudentCourse")
    public String addCourse(@Validated(Add.class) StudentCourse studentCourse){
        StudentCourse course1=studentCourseRepository.save(studentCourse);
        return course1!=null?"success":"fail";
    }
    //更新选课信息
    @PostMapping("/addStudentCourse")
    public String updateCourse(@Validated(Update.class) StudentCourse studentCourse){
        StudentCourse course1=studentCourseRepository.save(studentCourse);
        return course1!=null?"success":"fail";
    }









}
