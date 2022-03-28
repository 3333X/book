package com.demo.controller;

import com.demo.model.vo.NewAccountRequestVO;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "create")
    public String createNewAccount(@RequestBody @Validated NewAccountRequestVO newAccountRequestVO) {
        try {
            Integer result = accountService.newAccount(newAccountRequestVO);
            if (result != 0) {
                return "新用户" + newAccountRequestVO.getName() + "创建成功";
            } else {
                return "新用户创建失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "新用户创建失败";
        }
    }
}
