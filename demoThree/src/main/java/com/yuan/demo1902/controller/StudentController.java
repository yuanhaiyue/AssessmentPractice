package com.yuan.demo1902.controller;



import com.yuan.demo1902.entity.Student;
import com.yuan.demo1902.repository.StudentRepository;

import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class StudentController {

    final StudentRepository studentRepository;


    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    //根据学生id 删除学生信息
    @PostMapping("/deleteStudentId")
    public void deleteId(Integer id){
        studentRepository.deleteById(id);
    }
    //添加学生信息
    @PostMapping("/addStudent")
    public String addStudent(@Validated(Add.class) Student student){
       Student student1= studentRepository.save(student);
       return student1!=null?"success":"fail";
    }
    //更新学生信息
    @PostMapping("/updateStudent")
    public String updateStudent(@Validated(Update.class)Student student ){
        Student student1= studentRepository.save(student);
        return student1!=null?"success":"fail";
    }


}
