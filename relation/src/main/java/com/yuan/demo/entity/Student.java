package com.yuan.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
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

    @JsonIgnoreProperties(value = "students")
    @ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
    Set<Interest> interests;

    @JsonIgnoreProperties(value = "student")
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<StudentCourse> studentCourses;
}
