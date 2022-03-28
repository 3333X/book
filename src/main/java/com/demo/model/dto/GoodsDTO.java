package com.demo.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "goods")
public class GoodsDTO {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Integer number;

    @Column
    private Integer orderNo;

}
