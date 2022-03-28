package com.demo.service;

import com.demo.model.vo.NewAccountRequestVO;

public interface AccountService {

    /**
     * 创建新用户
     * @param newAccountRequestVO
     * @Author linzhicun
     * @Date 2022-03-27
     * @return
     */
    Integer newAccount(NewAccountRequestVO newAccountRequestVO);
}
