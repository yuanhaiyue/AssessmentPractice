package com.rj1902.demo.controller;

import com.rj1902.demo.entity.Department;
import com.rj1902.demo.entity.Inquiry;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.DEFAULT)
@SpringBootTest
class DepartmentControllerTest {

    @Autowired
    DepartmentController departmentController;





    @Test
    @DisplayName("模拟创建部门 获取所有部门信息  按指定条件查找信息")
    void establish() {
       String str= departmentController.establish(new Department("宣传部","张三"), departmentController.httpSession);
       assertThat(str).isEqualTo("创建成功");
       List<Department> list=departmentController.queryDepartment(departmentController.httpSession);
       assertThat(list.get(0).getDName()).isEqualTo("宣传部");
       Inquiry inquiry=new Inquiry();
       inquiry.setDName("宣传部");
       HashMap<String,Object> hashMap=departmentController.inquiryDepartment(inquiry,departmentController.httpSession);
       Department department=(Department)hashMap.get("Department");
       assertThat(department.getPerson()).isEqualTo("张三");
    }


}