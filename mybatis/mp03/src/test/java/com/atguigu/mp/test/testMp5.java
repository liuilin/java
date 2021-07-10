package com.atguigu.mp.test;

import com.atguigu.mp.beans.User;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.atguigu.mp.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Gakki
 * @date 2018/12/28 - 14:37
 */
public class testMp5 {

    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ac.getBean("employeeMapper", EmployeeMapper.class);

    UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

    @Test
    public void testDeleteAll() {
        employeeMapper.deleteAll();
    }

    @Test
    public void testDeleteUser() {
        System.out.println(userMapper.deleteById(1));
    }

    /**
     * 测试公共字段填充
     */
    @Test
    public void testMetaObjectHandler() {
        User user = new User();
        user.setId(2);
//        user.setName("tom");
        user.setLogicFlag(1);
//        userMapper.insert(user);
        userMapper.updateById(user);
    }
}
