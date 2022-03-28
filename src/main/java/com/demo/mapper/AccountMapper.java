package com.demo.mapper;

import com.demo.model.dto.AccountDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountMapper {

    @Insert("insert into account (name, sex, age, level) values (#{name}, #{sex}, #{age})")
    Integer insertNewAccount(@Param("name") String name, @Param("sex") Integer sex, @Param("age") Integer age, @Param("level") String level);

    @Select("select * from account where id = #{id} limit 1")
    AccountDTO selectAccountById(@Param("id") Integer accountNo);

    @Update("update account set point = #{point} where id = #{id}")
    Integer updateAccountVipPoint(@Param("id") Integer accountNo, @Param("point") Double point);
}
