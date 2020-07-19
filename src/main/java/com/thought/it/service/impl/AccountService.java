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

    public List<Account> findAllAccount() {
        // 开启事务

        return accountDao.findAllAccount();
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

    public void transfer(String sourceName, String targetName, Float money) {
        // 根据名称查询转出账户
        Account sourceAccount = accountDao.findByName(sourceName);
        
        // 根据名称查询转入账户
        Account targetAccount = accountDao.findByName(targetName);
        
        // 转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney() - money);

        // 转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney() + money);

        // 更新转出账户
        accountDao.updateAccount(sourceAccount);

//        int i = 1/0;

        // 更新转入账户
        accountDao.updateAccount(targetAccount);
    }

}
