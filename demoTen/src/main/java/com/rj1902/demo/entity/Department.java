package com.rj1902.demo.entity;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Data
@Component
public class Department {
    private String Id;
    @NotBlank(message = "部门名称不能为空")
    private String dName;
    private String person;
    private String upperId;
    private Date foundTime;
    private Date updateTime;
    public Department(){};
    public Department(@NotBlank(message = "部门名称不能为空") String dName, String person) {
        this.dName = dName;
        this.person = person;
    }

    public Department(@NotBlank(message = "部门名称不能为空") String dName, String person, String upperId) {
        this.dName = dName;
        this.person = person;
        this.upperId = upperId;
    }

    public void isEmpty(){
        upperId=upperId!=null?upperId:"0";
    }
    public void establish(){
        foundTime=updateTime=new Date();
    }
}
