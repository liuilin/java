package com.imugen.dao;

import com.imugen.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/17 - 10:34
 */
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    void delUser(Integer id);


    /**
     * 查询一个用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    /**
     * 模糊查询
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByName(String username);

    /**
     * 查询总条数
     *
     * @return
     */
    @Select("select count(*) from user")
    int findTotalCount();
}
