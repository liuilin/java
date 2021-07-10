package com.imugen.dao;

import com.imugen.domain.QueryVo;
import com.imugen.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 *
 * @author Gakki
 * @date 2018/12/13 - 14:52
 */
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     */
    void delUser(Integer userId);

    /**
     * 查询一个用户
     *
     * @param userId
     * @return
     */
    User findOne(Integer userId);

    /**
     * 根据姓模糊查询
     *
     * @param userName
     * @return
     */
    List<User> findByName(String userName);

    /**
     * 查询用户数
     *
     * @return
     */
    Integer findCount();

    /**
     * 根据QueryVo查询用户
     *
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);

    /**
     * 根据条件查询
     *
     * @param user
     * @return
     */
    List<User> findByCondition(User user);
}
