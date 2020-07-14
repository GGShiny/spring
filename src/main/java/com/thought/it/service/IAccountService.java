package com.thought.it.service;

import com.thought.it.domain.Account;

import java.util.List;

/**
 * @author 李亮
 * @date: 2020/7/13
 * @description:
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> finadAllAccount();

    /**
     * 根据id进行查询
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
