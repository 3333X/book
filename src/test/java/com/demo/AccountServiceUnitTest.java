package com.demo;

import com.demo.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AccountServiceUnitTest {

    @MockBean
    private AccountMapper accountMapper;

    @Test
    public void testInsert() {
        String name = new String();
        String level = new String();
        Integer age = 20;
        Integer sex = 1;
        accountMapper.insertNewAccount(name, sex, age, level);
        Mockito.verify(accountMapper).insertNewAccount(name, sex, age, level);
    }
}
