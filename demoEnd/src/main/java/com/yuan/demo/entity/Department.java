package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yuan.demo.utils.Add;
import com.yuan.demo.utils.Update;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "company_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(groups = Add.class)
    @NotNull(groups = Update.class)
    private Integer id;
    @NotBlank(message = "部门编号不能为空")
    private String code;
    @NotBlank(message = "部门名称不能为空")
    private String name;

    private String location;
    @JsonIgnore
    @JsonIgnoreProperties(value = "department")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
    private Set<User> users;


}
