package com.yuan.demo.service;


import com.yuan.demo.entity.HousingLoan;
import com.yuan.demo.utils.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerateVerification {
    private final Calculation calculation;

    public GenerateVerification(Calculation calculation) {
        this.calculation = calculation;

    }

    public Integer verification(){
       return calculation.verificationGenerate();
    }
    public Integer fourOperations(Integer nubOne,Integer nubTwo,Integer symbol){
        return calculation.fourOperations(nubOne, nubTwo, symbol);
    }
}
