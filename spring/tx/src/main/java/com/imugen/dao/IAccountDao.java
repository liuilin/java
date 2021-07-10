package com.imugen.dao;

import com.imugen.domain.Account;

/**
 * @author Daniel Liu 2020/3/1 8:18
 */
public interface IAccountDao {

    Account findByName(String username);

    void update(Account account);
}