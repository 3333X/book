package com.demo.service.impl;

import com.demo.mapper.AccountMapper;
import com.demo.mapper.GoodsMapper;
import com.demo.mapper.OrderMapper;
import com.demo.model.dto.AccountDTO;
import com.demo.model.vo.NewOrderRequestVO;
import com.demo.model.vo.OrderDetailResponseVO;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author linzhicun
 * @since 2022-03-27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public String newOrder(NewOrderRequestVO newOrderRequestVO) {
        Integer accountNo = newOrderRequestVO.getAccountNo();
        Double price = newOrderRequestVO.getPrice();
        // 插入新订单
        Integer newOrderResult = orderMapper.insertNewOrder(accountNo, price);
        AccountDTO accountDTO = accountMapper.selectAccountById(accountNo);
        if (accountDTO == null) {
            return null;
        }
        Double vipPoint = accountDTO.getPoint();
        // 更新顾客积分
        if ("Coper".equals(accountDTO.getLevel())) {
            vipPoint += price;
        } else if ("Silver".equals(accountDTO.getLevel())) {
            vipPoint += price * 2;
        } else {
            vipPoint += price * 3;
        }
        Integer updateAccountResult = accountMapper.updateAccountVipPoint(accountNo, vipPoint);
        if (newOrderResult != 0 && updateAccountResult != 0) {
            return "success";
        }
        return null;
    }

    @Override
    public OrderDetailResponseVO selectOrderDetail(Integer orderNo) {

        OrderDetailResponseVO orderDetailResponseVO = new OrderDetailResponseVO();
        orderDetailResponseVO.setGoodsDetail(goodsMapper.selectGoodsByOrderNo(orderNo));
        orderDetailResponseVO.setOrderNo(orderNo);
        orderDetailResponseVO.setTotalPrice(orderMapper.selectPriceByOrderNo(orderNo));
        return orderDetailResponseVO;
    }
}
