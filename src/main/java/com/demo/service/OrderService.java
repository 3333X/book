package com.demo.service;

import com.demo.model.vo.NewOrderRequestVO;
import com.demo.model.vo.OrderDetailResponseVO;

public interface OrderService {

    /**
     * 创建新订单
     * @param newOrderRequestVO
     * @Author linzhicun
     * @Date 2022-03-27
     * @return
     */
    String newOrder(NewOrderRequestVO newOrderRequestVO);

    /**
     * 查询订单详情
     * @param orderNo
     * @Author linzhicun
     * @Date 2022-03-27
     * @return
     */
    OrderDetailResponseVO selectOrderDetail(Integer orderNo);
}
