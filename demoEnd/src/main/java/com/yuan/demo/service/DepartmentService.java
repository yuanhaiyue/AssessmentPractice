package com.yuan.demo.service;


import com.yuan.demo.entity.Department;
import com.yuan.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;


@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public String addDepartment(Department department){
       Department department1= departmentRepository.save(department);
       return department!=null?"success":"fail";
    }

    public void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }

    public Department selectDepartmentName(String name){
        return departmentRepository.findByName(name);
    }
    public String saveDepartment(Department department){
        Department department1=departmentRepository.save(department);
        return department1!=null?"success":"fail";
    }

}
