package com.demo.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "account")
public class AccountDTO {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer sex;

    @Column
    private Integer age;

    @Column
    private String level;

    @Column
    private Double point;

}
