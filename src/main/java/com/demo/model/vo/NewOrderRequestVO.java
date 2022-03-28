package com.demo.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class NewOrderRequestVO {

    @NotNull
    private Integer accountNo;

    @NotNull
    private Double price;
}
