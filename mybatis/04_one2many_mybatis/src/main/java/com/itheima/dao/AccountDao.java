package com.imugen.dao;

import com.imugen.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/17 - 15:14
 */
public interface AccountDao {

    /**
     * 查询所有账户，并获取每个账户所属的用户信息
     * 一对一使用立即加载
     * 一对多使用延迟加载
     *
     * @return
     */
    @Select("select * from Account")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(column = "uid", property = "user", one = @One(select = "com.itheima.dao.UserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> efindAll();

public static void main(String[] args){
    
}
    /**
     * 根据账户id查询用户信息
     *
     * @param userId
     * @return
     */
    @Select("select * from account where uid=#{userId}")
    List<Account> findAccountById(Integer userId);
}
