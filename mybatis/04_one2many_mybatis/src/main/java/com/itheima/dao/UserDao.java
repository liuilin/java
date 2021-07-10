package com.imugen.dao;

import com.imugen.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/17 - 10:34
 */
public interface UserDao {

    /**查询所有
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "id",property = "accounts",
                    many = @Many(select = "com.itheima.dao.AccountDao.findAccountById",fetchType = FetchType.LAZY))

    })
    List<User> findAll();

    /**
     * 查询一个用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap("userMap")
    User findById(Integer id);

    /**
     * 模糊查询
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findByName(String username);
}
