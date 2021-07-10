package com.imugen.test;

import com.imugen.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = "classpath:bean.xml" )
public class IAccountServiceTest {

    @Autowired
    @Qualifier( "proxyAccountService" )
    private IAccountService as;

    @Test
    public void testTransfer() {
        as.transfer("Jin", "Mugen", 100f);
    }

//    @Test
//    public void t1() {
//        Stream.of(ast.findAll()).forEach(System.out::println);
//    }
}
