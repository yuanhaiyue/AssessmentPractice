package com.yuan.demo1902.entity;


import com.yuan.demo1902.util.Add;
import com.yuan.demo1902.util.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;

@Repository
@Component
@Entity
public class StudentCourse {

    @Null(groups = Add.class)
    @NotNull(groups = Update.class)
    @Id
    private Integer id;

    private Integer studentId;

    private Integer courseId;

    private Date selectDate;

    private Double achievement;


}
