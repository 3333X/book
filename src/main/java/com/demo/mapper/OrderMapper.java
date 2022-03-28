package com.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    @Insert("insert into orderForm (account_no, price) values (#{account_no}, #{price})")
    Integer insertNewOrder(@Param("account_no") Integer accountNo, @Param("price") Double price);

    @Select("select price from orderForm where id = #{order_no}")
    Double selectPriceByOrderNo(@Param("order_no") Integer orderNo);
}
