package com.imugen.test;

import com.imugen.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Gakki
 * @date 2018/12/26 - 18:37
 */
public class AccountServiceImplTest {

    @Test
    public void findAll() {
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //调用方法
        as.findAll();
    }

    @Test
    public void saveAccount() {
    }
}