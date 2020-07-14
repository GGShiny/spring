package com.thought.it.controller;

import com.thought.it.dao.impl.AccountDao;
import com.thought.it.service.impl.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 李亮
 * @date: 2020/7/14
 * @description:
 */
public class AccountController {
    public static void main(String[] args) {
        // 1.获取核心容器对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");

        AccountService accountService = classPathXmlApplicationContext.getBean("accountService", AccountService.class);
        accountService.saveAccount();
//        AccountDao accountDao = classPathXmlApplicationContext.getBean("accountDao", AccountDao.class);
//        accountDao.saveAccount();
    }
}
