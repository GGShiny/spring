package com.thought.it.test;

import com.thought.it.domain.Account;
import com.thought.it.service.impl.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 李亮
 * @date: 2020/7/14
 * @description:
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = classPathXmlApplicationContext.getBean("accountService", AccountService.class);
        List<Account> accounts = accountService.finadAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }
    }
}
