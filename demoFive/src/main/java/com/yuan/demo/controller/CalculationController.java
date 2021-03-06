package com.yuan.demo.controller;


import com.yuan.demo.entity.HousingLoan;
import com.yuan.demo.service.GenerateVerification;
import com.yuan.demo.utils.Calculation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/x")
@RestController
public class CalculationController {

    final GenerateVerification generateVerification;
    public CalculationController(GenerateVerification generateVerification) {
        this.generateVerification = generateVerification;
    }



    @GetMapping("/verification/{num}")
    public Integer verification(@PathVariable String num){
        return generateVerification.verification();
    }

    @GetMapping("/FourOperations")
    public Integer FourOperations(Integer nubOne,Integer nubTwo,Integer symbol){
        System.out.println(symbol);
        return generateVerification.fourOperations(nubOne, nubTwo, symbol);
    }

    @PostMapping("/HousingLoan")
    public String HousingLoan(HousingLoan housingLoan){
        return housingLoan.toString();
    }


}
