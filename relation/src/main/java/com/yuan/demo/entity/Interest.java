package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cascade_interest")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    //中间表没有其他字段使用的使用方法
    @JsonIgnoreProperties(value = "interest")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cascade_student_interest",
            joinColumns = {@JoinColumn(name = "interest_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    Set<Student> students;



}
