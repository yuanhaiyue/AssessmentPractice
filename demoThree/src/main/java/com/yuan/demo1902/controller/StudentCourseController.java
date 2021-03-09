package com.yuan.demo1902.controller;


import com.yuan.demo1902.entity.StudentCourse;
import com.yuan.demo1902.repository.StudentCourseRepository;
import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @PostMapping("/updateStudentCourse")
    public String updateCourse(@Validated(Update.class) StudentCourse studentCourse){
        StudentCourse course1=studentCourseRepository.save(studentCourse);
        return course1!=null?"success":"fail";
    }
    //根据学生编号查询学生所选课程的接口
    @GetMapping("/getStudentCourse")
    public List<StudentCourse> getStudentCourse(Integer id){
        return studentCourseRepository.findByStudentId(id);
    }
    //根据课程名称，统计查询该课程的平均分
    @GetMapping("/getCourseName")
    public Double getCourseName(String name){
        return studentCourseRepository.findByName(name);
    }








}
