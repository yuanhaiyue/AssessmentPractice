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
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "company_check_work")
public class CheckWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(groups = Add.class)
    @NotNull(groups = Update.class)
    private Integer id;

    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = "checkWork")
    @ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = "checkWork")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Shift shift;

    @NotBlank(message = "工作日期不能为空")
    private Date workDate;
}
