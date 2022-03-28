package com.demo.model.vo;

import com.demo.model.dto.GoodsDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.util.List;

@Data
@Accessors(chain = true)
public class OrderDetailResponseVO {

    private Integer orderNo;

    private Double totalPrice;

    private List<GoodsDTO> goodsDetail;
}
