package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @author Daniel Liu 2020/1/18 9:01
 */
public interface UserDao {

    User findByUsername(String username);

    void save(User user);

    User findByCode(String code);

    void update(User user);

    User findByUsernameAndPassword(String username, String password);
}
