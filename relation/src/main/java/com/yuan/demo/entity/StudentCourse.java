package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cascade_student_course")
@Setter
@Getter
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @JsonIgnoreProperties(value = "studentCourses")
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    @JsonIgnoreProperties(value = "studentCourses")
    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date selectDate;
    Float achievement;
}
