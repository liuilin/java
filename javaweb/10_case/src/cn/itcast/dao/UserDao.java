package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的dao
 *
 * @author Gakki
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return user
     */
    List<User> findAll();

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return User
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 删除用户
     * @param id
     */
    void delete(int id);

    /**
     * 查询用户
     * @param id
     * @return
     */
    User findUser(int id);

    void update(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
