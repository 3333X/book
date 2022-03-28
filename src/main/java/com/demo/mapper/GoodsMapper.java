package com.demo.mapper;

import com.demo.model.dto.GoodsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select id,name,price,number,order_no as orderNo from goods where order_no = #{order_no}")
    List<GoodsDTO> selectGoodsByOrderNo(@Param("order_no") Integer orderNo);
}
