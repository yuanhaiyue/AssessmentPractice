package com.yuan.demo.controller;


import com.yuan.demo.entity.Leader;
import com.yuan.demo.repository.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/leader")
@RestController
public class LeaderController {

    @Autowired
    LeaderRepository leaderRepository;

    //领导级联查询
    @GetMapping("/select")
    public List<Leader> select(){
        return leaderRepository.findAll();
    }


}

