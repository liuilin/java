package com.imugen.dao;

import com.imugen.domain.User;

/**
 * @author Daniel Liu 2020/1/16 8:49
 */
class LoginDaoTest {
    @org.junit.jupiter.api.Test
    void login() {
        User user = new User();
        user.setName("Daniel");
        user.setPassword("123");
        System.out.println(new LoginDao().login(user));
    }
}