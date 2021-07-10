package com.imugen.service.impl;

import com.imugen.config.SpringConfig;
import com.imugen.service.IAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Daniel Liu 2020/3/1 8:46
 */
class AccountServiceImplTest {

    @org.junit.jupiter.api.Test
    void transfer() {
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        IAccountService accountService = ac.getBean("accountServiceImpl", IAccountService.class);
        accountService.transfer("Jin","Mugen",100);
    }
}