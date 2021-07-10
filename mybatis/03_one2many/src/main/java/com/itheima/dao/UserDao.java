package com.imugen.dao;

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
     * 查询一个用户
     *
     * @param userId
     * @return
     */
    User findOne(Integer userId);

}
