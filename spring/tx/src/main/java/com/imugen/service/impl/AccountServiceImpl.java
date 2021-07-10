package com.imugen.service.impl;

import com.imugen.dao.IAccountDao;
import com.imugen.domain.Account;
import com.imugen.service.IAccountService;
import com.imugen.utils.ArithmeticUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Daniel Liu 2020/3/1 8:15
 */
@Service
@Transactional( propagation = Propagation.SUPPORTS, readOnly = true )
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Transactional( propagation = Propagation.REQUIRED, readOnly = false )
    public void transfer(String form, String target, double money) {
        Account one = accountDao.findByName(form);
        Account two = accountDao.findByName(target);
        one.setMoney(ArithmeticUtil.sub(one.getMoney(), money));
        two.setMoney(ArithmeticUtil.add(two.getMoney(), money));
        accountDao.update(one);
        int i = 1 / 0;
        accountDao.update(two);
    }
}