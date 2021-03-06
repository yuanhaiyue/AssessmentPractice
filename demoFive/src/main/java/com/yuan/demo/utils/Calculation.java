package com.yuan.demo.utils;


import com.yuan.demo.entity.HousingLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Calculation {



    public Integer verificationGenerate(){
        return (int) (Math.random() * 900000) + 100000;
    }
   public Integer fourOperations(Integer nubOne,Integer nubTwo,Integer symbol){
        switch (symbol){
            case 4:
                return nubOne/nubTwo;
            case 3:
                return nubOne*nubTwo;
            case 1:
                return nubOne+nubTwo;
            case 2:
                return nubOne-nubTwo;
        }
        return 0;
   }

}
