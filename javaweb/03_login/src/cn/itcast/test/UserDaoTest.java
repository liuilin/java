package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

/**
 * @author Gakki
 * @date 2018/11/15 - 10:27
 */
public class UserDaoTest {


    @Test
    public void testlogin() {
        User loginUser = new User();
        loginUser.setUsername("Gakki");
        loginUser.setPassword("12");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        System.out.println(user);
    }
}
