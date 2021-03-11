package com.yuan.demo.controller;


import com.yuan.demo.entity.Student;
import com.yuan.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/select")
    public List<Student> select(){
        return studentRepository.findAll();
    }



}
