package com.demo.controller;

import com.demo.model.vo.NewOrderRequestVO;
import com.demo.model.vo.OrderDetailResponseVO;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 创建订单
    @PostMapping(value = "create")
    public String createNewOrder(@RequestBody @Validated NewOrderRequestVO newOrderRequestVO) {
        try {
            String result = orderService.newOrder(newOrderRequestVO);
            if ("success".equals(result)) {
                return "订单创建成功";
            } else {
                return "订单创建失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "订单创建失败";
        }
    }

    // 根据订单号查询订单
    @PostMapping(value = "select")
    public OrderDetailResponseVO selectOrderByOrderNo(@RequestBody @Validated @NotNull Integer orderNo) {

        try {
            OrderDetailResponseVO orderDetailResponseVO = orderService.selectOrderDetail(orderNo);
            return orderDetailResponseVO;
        } catch (Exception e) {
            e.printStackTrace();
            return new OrderDetailResponseVO();
        }
    }
}
