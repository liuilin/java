package com.imugen.test;

import com.imugen.domain.Account;
import com.imugen.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * xml用locations
 * 注解用
 * @author Gakki
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = "classpath:applicationContext.xml" )
public class AccountDaoImplTest {

    @Autowired
    private IAccountService as;


    @Test
    public void findAll() {
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void findAccountById() {
        System.out.println(as.findAccountById(1));
    }

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setName("Jin");
        account.setMoney(124f);
        as.saveAccount(account);
    }

    @Test
    public void deleteAccount() {
        as.deleteAccount(4);
    }

    @Test
    public void updateAccount() {
        Account account = as.findAccountById(5);
        account.setMoney(125f);
        as.updateAccount(account);
    }


}