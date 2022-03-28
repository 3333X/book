package com.demo;

import com.demo.mapper.GoodsMapper;
import com.demo.mapper.OrderMapper;
import com.demo.model.dto.GoodsDTO;
import com.demo.model.dto.OrderFormDTO;
import com.demo.model.vo.OrderDetailResponseVO;
import com.demo.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

@SpringBootTest
public class OrderServiceUnitTest {

    @MockBean
    private OrderMapper orderMapper;

    @MockBean
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderService orderService;

    @Test
    public void testInsert() {
        Integer accountNo = 1;
        Double price = 20.0;
        orderMapper.insertNewOrder(accountNo, price);
        Mockito.verify(orderMapper).insertNewOrder(accountNo, price);
    }

    @Test
    public void getOrder() {

        OrderFormDTO orderFormDTO = new OrderFormDTO();
        orderFormDTO.setAccountNo(1);
        orderFormDTO.setPrice(20.0);

        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setOrderNo(1);
        goodsDTO.setPrice(20.0);
        goodsDTO.setName("111");
        goodsDTO.setNumber(1);

        Mockito.when(orderMapper.selectPriceByOrderNo(orderFormDTO.getId())).thenReturn(orderFormDTO.getPrice());
        Mockito.when(goodsMapper.selectGoodsByOrderNo(1)).thenReturn(Collections.singletonList(goodsDTO));

        OrderDetailResponseVO result = orderService.selectOrderDetail(1);
        Assertions.assertThat(result.getTotalPrice()).isEqualTo(20.0);
        Assertions.assertThat(result.getGoodsDetail().get(0).getName()).isEqualTo("111");
        Assertions.assertThat(result.getGoodsDetail().get(0).getPrice()).isEqualTo(20.0);
        Assertions.assertThat(result.getGoodsDetail().get(0).getNumber()).isEqualTo(1);
        Assertions.assertThat(result.getGoodsDetail().get(0).getOrderNo()).isEqualTo(1);
    }
}
