package com.yuan.demo.service;


import com.yuan.demo.entity.Shift;
import com.yuan.demo.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftService {
    @Autowired
    ShiftRepository shiftRepository;

    public String save(Shift shift){
        Shift shift1=shiftRepository.save(shift);
        return shift!=null?"success":"fail";
    }

    public void delete(Integer id){
        shiftRepository.deleteById(id);
    }

    public Shift select(String name){
        return shiftRepository.findByName(name);
    }



}
