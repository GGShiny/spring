package com.thought.it.test;

import com.thought.it.config.SpringConfiguration;
import com.thought.it.domain.Account;
import com.thought.it.service.impl.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 李亮
 * @date: 2020/7/14
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAll(){
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        AnnotationConfigApplicationContext classPathXmlApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        AccountService accountService = classPathXmlApplicationContext.getBean("accountService", AccountService.class);
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb", 100f);
    }
}
