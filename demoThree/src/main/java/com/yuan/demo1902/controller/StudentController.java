package com.yuan.demo1902.controller;



import com.yuan.demo1902.entity.Student;
import com.yuan.demo1902.repository.StudentRepository;

import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    //通过学生名字和密码来查询学生信息
    @PostMapping("/getStudent")
    public Student getStudent(String name,String password){
        return studentRepository.findByNameAndPassword(name, password);
    }
//    根据系部查询学生的接口，结果分页查询并按学生编号升序排序
    @PostMapping("/getStudentDp")
    public List<Student> getStudent(String department){
        Sort sort=Sort.by(Sort.Direction.ASC,"code");
        Pageable pageable= PageRequest.of(0, 5);

        return studentRepository.findByDepartment(department, pageable).getContent();
    }
    //根据系部和性别来查询
    @PostMapping("/getStudentSexDp")
    public List<Student> getStudentSexDp(String sex,String department){
        return studentRepository.findBySexAndDepartment(sex, department);
    }
    //根据学生编号，统计查询该生的平均分
    @PostMapping("/getStudentAchievement")
    public Double getStudentAchievement(Integer id){
        return studentRepository.getAchievement(id);
    }

}
