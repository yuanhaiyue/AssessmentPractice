package com.rj1902.demo.controller;

import com.rj1902.demo.entity.Department;
import com.rj1902.demo.entity.Inquiry;
import com.rj1902.demo.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@RestController
public class DepartmentController {
    final DepartmentService service;
    final HttpSession httpSession;
    public DepartmentController(DepartmentService service, HttpSession httpSession) {
        this.service = service;
        this.httpSession = httpSession;
    }

    @PostMapping("/establish")
    public String establish(Department department, HttpSession session){
        return service.establish(department, session);
    }
    @GetMapping("/query")
    public List<Department> queryDepartment(HttpSession session){
        return service.queryDepartment(session);
    }
    @GetMapping("/inquiry")
    public HashMap<String, Object> inquiryDepartment (Inquiry inquiry, HttpSession session){
        return service.inquiryDepartment(inquiry, session);
    }

}
