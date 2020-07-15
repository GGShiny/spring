package com.thought.it.service.impl;

import com.thought.it.dao.impl.AccountDao;
import com.thought.it.domain.Account;
import com.thought.it.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李亮
 * @date: 2020/7/13
 * @description:
 */
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> finadAllAccount() {
        return accountDao.finadAllAccount();
    }

    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
