package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Leader leader;
}
