package com.yuan.demo1902.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CourseStudent {

    private String code;
    private String name;
    private String sex;
    private String department;

    public CourseStudent(String code, String name, String sex, String department) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.department = department;
    }
}
