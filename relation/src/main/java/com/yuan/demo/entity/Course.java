package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cascade_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private Float credit;

    @JsonIgnoreProperties(value = "course")
    @OneToMany(mappedBy ="course",fetch = FetchType.EAGER)
    private List<StudentCourse> studentCourses;


}
