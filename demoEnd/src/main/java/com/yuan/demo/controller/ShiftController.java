package com.yuan.demo.controller;

import com.yuan.demo.entity.Shift;
import com.yuan.demo.service.ShiftService;
import com.yuan.demo.utils.Add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shift")
@RestController
public class ShiftController {

    @Autowired
    ShiftService service;

    @GetMapping ("/delete")
    public void delete(Integer id){
        service.delete(id);
    }

    @PostMapping("/save")
    public String save(@Validated(value = Add.class) Shift shift){
        return service.save(shift);
    }

    @GetMapping("/select")
    public Shift select(String name){
        return service.select(name);
    }
}
