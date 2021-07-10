package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * @author Daniel Liu 2020/1/18 9:33
 */
public interface UserService {
    /**
     * 注册
     *
     * @param user
     * @return
     */
    boolean registered(User user);

    boolean active(String code);

    User login(User user);
}
