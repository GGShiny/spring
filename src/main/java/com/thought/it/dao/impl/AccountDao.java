package com.thought.it.dao.impl;

import com.thought.it.dao.IAccountDao;
import com.thought.it.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.experimental.categories.ExcludeCategories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李亮
 * @date: 2020/7/13
 * @description:
 */
//@Repository("accountDao")
public class AccountDao implements IAccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> finadAllAccount() {
        List<Account> query = null;
        try {
            query = runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        return query;
    }

    public Account findById(Integer accountId) {
        Account query = null;
        try {
            query = runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), accountId);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        return query;
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id = ?", accountId);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
