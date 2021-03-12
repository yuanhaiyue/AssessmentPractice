package com.yuan.demo.controller;


import com.yuan.demo.entity.Department;
import com.yuan.demo.entity.User;
import com.yuan.demo.service.DepartmentService;
import com.yuan.demo.utils.Add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
@Validated
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/selectName")
    public Department selectName(String name){
        return departmentService.selectDepartmentName(name);
    }


    @GetMapping("/selectNameUser")
    public Set<User> selectId(String name){
        return departmentService.selectDepartmentName(name).getUsers();
    }


    @PostMapping("/saveDepartment")
    public String saveDepartment(@Validated(value = Add.class) Department department){
        return departmentService.saveDepartment(department);
    }


    @GetMapping("/deleteDepartment")
    public void deleteDepartment(Integer id){
        departmentService.deleteDepartment(id);
    }

}
