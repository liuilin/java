package cn.itcast.travel.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.extra.mail.MailUtil;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

/**
 * @author Daniel Liu 2020/1/18 9:33
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();
    private final String target = "imugen@163.com";

    @Override
    public boolean registered(User user) {
        User u = userDao.findByUsername(user.getUsername());
        if (u != null) {
            return false;
        }
        //激活码状态
        user.setStatus("N");
        //激活码
        user.setCode(UUID.randomUUID().toString());
        userDao.save(user);
        String content = "http://localhost/travel/user/verify?code=" + user.getCode();
        MailUtil.send(target, "测试一下", content, true);
        return true;
    }

    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        if (user!=null) {
            userDao.update(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}