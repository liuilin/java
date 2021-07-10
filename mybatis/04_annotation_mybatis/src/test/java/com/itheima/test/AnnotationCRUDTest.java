package com.imugen.test;

import com.imugen.dao.UserDao;
import com.imugen.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Gakki
 * @date 2018/12/17 - 11:22
 */
public class AnnotationCRUDTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }
    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }
    
    @Test
    public void testSelect(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("Mugen");
//        user.setBirthday(new Date());
        user.setSex("男");
//        user.setAddress("四川");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(60);
        user.setUsername("FFFFFF");
        user.setSex("女");
        user.setAddress("Japan");

        userDao.updateUser(user);
    }

    @Test
    public void testDelUser(){
        userDao.delUser(60);
    }

    @Test
    public void testFindById(){
        User u = userDao.findById(61);
        System.out.println(u);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotalCount(){
        System.out.println(userDao.findTotalCount());
    }

}