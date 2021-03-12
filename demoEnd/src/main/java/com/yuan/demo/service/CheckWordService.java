package com.yuan.demo.service;

import com.yuan.demo.entity.CheckWork;
import com.yuan.demo.repository.CheckWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckWordService {

    @Autowired
    CheckWorkRepository checkWorkRepository;

    public String save(CheckWork checkWork){
        CheckWork checkWork1=checkWorkRepository.save(checkWork);
        return checkWork1!=null?"success":"fail";
    }

    public void delete(Integer id){
        checkWorkRepository.deleteById(id);
    }



}
