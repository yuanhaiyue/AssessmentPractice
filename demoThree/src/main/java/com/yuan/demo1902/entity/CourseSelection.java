package com.yuan.demo1902.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
@Component
@Data
@NoArgsConstructor
public class CourseSelection {
    private String code;
    private String name;
    private String sex;
    private String department;
    private Date selectDate;
    private Double achievement;

    public CourseSelection(String code, String name, String sex, String department, Date selectDate, Double achievement) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.selectDate = selectDate;
        this.achievement = achievement;
    }
}
