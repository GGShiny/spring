package com.thought.it.service.impl;

import com.thought.it.dao.impl.AccountDao;
import com.thought.it.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 李亮
 * @date: 2020/7/13
 * @description:
 */
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
