package com.imugen.service.impl;

import com.imugen.beans.Account;
import com.imugen.mapper.AccountMapper;
import com.imugen.service.AccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mugen
 * @since 2018-12-28
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
