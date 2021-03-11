package com.yuan.demo.controller;

import com.yuan.demo.entity.Interest;
import com.yuan.demo.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/interest")
@RestController
public class InterestController {

    @Autowired
    InterestRepository interestRepository;

    @GetMapping("/select")
    public List<Interest> select(){
        return interestRepository.findAll();
    }



}
