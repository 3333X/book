package com.demo.service.impl;

import com.demo.mapper.AccountMapper;
import com.demo.model.vo.NewAccountRequestVO;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 顾客 服务实现类
 * </p>
 *
 * @author linzhicun
 * @since 2022-03-27
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Integer newAccount(NewAccountRequestVO newAccountRequestVO) {
        String name = newAccountRequestVO.getName();
        Integer sex = newAccountRequestVO.getSex();
        Integer age = newAccountRequestVO.getAge();
        String level = newAccountRequestVO.getLevel();
        Integer result = accountMapper.insertNewAccount(name, sex, age, level);
        return result;
    }
}
