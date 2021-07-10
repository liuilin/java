package com.imugen.test;

import com.imugen.dao.AccountDao;
import com.imugen.dao.UserDao;
import com.imugen.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Gakki
 * @date 2018/12/17 - 15:16
 */
public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDao = session.getMapper(AccountDao.class);
    }
    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAllAccount(){
//        List<Account> accounts = accountDao.findAll();
//        for (Account account : accounts) {
//            System.out.println(account);
//            System.out.println(account.getUser());
//        }
        
    }

}