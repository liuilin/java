package com.imugen.dao;

import com.imugen.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/26 - 17:58
 */
@Repository("accountDao")
public interface AccountDao {

    /**
     * 查询所有账户
     *
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户信息
     *
     * @param account
     */
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);
}
