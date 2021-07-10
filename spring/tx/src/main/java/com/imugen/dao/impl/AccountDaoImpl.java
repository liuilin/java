package com.imugen.dao.impl;

import com.imugen.dao.IAccountDao;
import com.imugen.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Daniel Liu 2020/3/1 8:19
 */
@Repository
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findByName(String username) {
        List<Account> list = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), username);
        if (list.size() > 1) {
            throw new RuntimeException("数据异常");
        }
        return list.get(0);
    }

    public void update(Account account) {
        jdbcTemplate.update("update account set money=? where name=?", account.getMoney(),account.getName());
    }
}