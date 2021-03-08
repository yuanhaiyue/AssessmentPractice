package com.yuan.demo1902.entity;


import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Component
@Data
public class Course {
    @Null(groups = Add.class)
    @NotNull(groups = Update.class)
    @Id
    private Integer id;

    private String code;

    private String name;

    private Double credit;
}
