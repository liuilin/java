package com.imugen.test;

import com.imugen.dao.AccountDao;
import com.imugen.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/26 - 20:16
 */
public class TestMybatis {

    @Test
    public void testFindAll() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.bak");
        //创建SQLSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession sqlSession = factory.openSession();
        //获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        //查询所有
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        sqlSession.close();
        in.close();
    }
    @Test
    public void testInsert() throws IOException {
        Account account = new Account();
        account.setName("Gakki");
        account.setMoney(10000);
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.bak");
        //创建SQLSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession sqlSession = factory.openSession();
        //获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        //添加用户
        dao.saveAccount(account);
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
