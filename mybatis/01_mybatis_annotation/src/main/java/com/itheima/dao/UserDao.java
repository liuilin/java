package com.imugen.dao;

import com.imugen.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 持久层dao
 *
 * @author Gakki
 * @date 2018/12/11 - 20:54
 */
public interface UserDao {


    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
