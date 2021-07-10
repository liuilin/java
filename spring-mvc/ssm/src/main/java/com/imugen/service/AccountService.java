package com.imugen.service;

import com.imugen.domain.Account;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/26 - 18:01
 */
public interface AccountService {

    /**
     * 查询所有账户
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户信息
     *
     * @param account
     */
    void saveAccount(Account account);

}
