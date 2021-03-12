package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yuan.demo.utils.Add;
import com.yuan.demo.utils.Update;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="company_shift")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(groups = Add.class)
    @NotNull(groups = Update.class)
    private Integer id;
    @NotBlank(message = "编号不能为空")
    private String code;
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "时薪不能为空")
    private String hourlyWage;
    @NotBlank(message = "工作时长不能为空")
    private Integer workHours;
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = "shift")
    @OneToMany(mappedBy = "shift",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<CheckWork> checkWork;




}
