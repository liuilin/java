package com.imugen.dao;

import com.imugen.domain.User;

import java.util.List;

/**
 * @author Daniel Liu 2020/2/11 15:52
 */
public interface UserDao {
    List<User> findAll();
}
