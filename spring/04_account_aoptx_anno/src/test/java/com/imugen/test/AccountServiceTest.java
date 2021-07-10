package com.imugen.test;

import com.imugen.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = "classpath:bean.xml" )
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer() {
        //正常执行会出错，java.sql.SQLException: Can't call commit when autocommit=true。因为执行顺序有问题
        // 先执行的最终通知关闭连接后，才执行的commit提交此时没有connect连接了就会从数据源中拿一个连接
        // 此时前置通知已经执行完毕auto commit已经为true，所以出错。解决：控制事务想用注解的话 用环绕通知解决执行顺序问题
        as.transfer("aaa", "bbb", 100f);
    }

}
