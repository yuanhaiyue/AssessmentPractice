package com.yuan.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cascade_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private String sex;

    private String age;

    private String email;

    private String phone;

    private String password;

    @JsonIgnoreProperties(value = "students")
    @ManyToOne (cascade = CascadeType.ALL)
    Department department;


}
