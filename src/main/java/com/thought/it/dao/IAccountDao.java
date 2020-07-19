package com.thought.it.dao;

import com.thought.it.domain.Account;

import java.util.List;

/**
 * @author 李亮
 * @date: 2020/7/13
 * @description:
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

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

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findByName(String accountName);

}
