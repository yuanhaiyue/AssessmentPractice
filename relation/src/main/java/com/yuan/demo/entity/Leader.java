package com.yuan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cascade_leader")
@Data

public class Leader implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    @JsonIgnoreProperties(value = "leader")
    @OneToOne(mappedBy = "leader",cascade = CascadeType.ALL)
    private Department department;
}
