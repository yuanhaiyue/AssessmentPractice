package com.yuan.demo1902.entity;


import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Component
@Data
@Entity
public class Student {
    @Null(groups = Add.class)
    @NotNull(groups = Update.class)
    @Id
    private Integer id;

    private String code;

    private String name;

    private String sex;

    private Integer age;

    private String email;

    private String phone;

    private String password;

    private String department;


}
