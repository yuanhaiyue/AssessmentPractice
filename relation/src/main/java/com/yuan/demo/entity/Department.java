package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import java.util.Set;

@Transactional
@Entity
@Table(name = "cascade_department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private String location;


    @JsonIgnoreProperties(value = "department")
    @OneToOne(cascade = CascadeType.ALL)
    private Leader leader;


    @JsonIgnoreProperties(value = "department")
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "department")
    Set<Student> students;



}
