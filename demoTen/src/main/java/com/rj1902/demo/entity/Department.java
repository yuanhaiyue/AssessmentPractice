package com.rj1902.demo.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Department {
    private Integer Id;
    private String dName;
    private String person;
    private Integer upperId;
    private Date foundTime;
    private Date updateTime;

}
