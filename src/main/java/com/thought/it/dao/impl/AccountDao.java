package com.thought.it.dao.impl;

import com.thought.it.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author 李亮
 * @date: 2020/7/13
 * @description:
 */
@Repository("accountDao")
public class AccountDao implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存成功");
    }
}
