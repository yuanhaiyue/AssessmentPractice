package com.yuan.demo.controller;


import com.yuan.demo.entity.Department;
import com.yuan.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/department")
@RestController
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/select")
    public List<Department> select(){
        return departmentRepository.findAll();
    }
    //级联增：
    //就是说部门新增时，如果携带的领导者的信息，在领导的表中是不存在，则它也会新增一个新领导
    @PostMapping("/save")
    public String save(Department department){
        Department save=departmentRepository.save(department);
        return save!=null?"sucess":"fail";
    }
}
