package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yuan.demo.utils.Add;
import com.yuan.demo.utils.Update;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "company_user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(groups = Add.class)
    @NotNull(groups = Update.class)
    private Integer id;
    @NotBlank(message = "编号不能为空")
    private String code;
    @NotBlank(message = "名字不能为空")
    private String name;

    private String sex;
    @Range(min = 16,max = 150,message = "年龄未达标准")
    private Integer age;
    @Email(message = "邮箱不合法")
    private String email;
    @Size(min = 11,message = "正确输入11位手机号")
    @Column(length = 11)
    private Integer phone;
    @Length(min = 6,message = "密码至少要到六位")
    private String password;

    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = "users")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Department department;

    @NotFound(action = NotFoundAction.EXCEPTION)
    @JsonIgnoreProperties(value = "user")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Set<CheckWork> checkWork;

}
