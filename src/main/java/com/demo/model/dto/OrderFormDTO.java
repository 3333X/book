package com.demo.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "orderForm")
public class OrderFormDTO {

    @Id
    @Column
    private Integer id;

    @Column(name = "account_no")
    private Integer accountNo;

    @Column
    private Double price;

}
