package com.imugen.test;

import com.imugen.dao.UserDao;
import com.imugen.domain.QueryVo;
import com.imugen.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的crud操作
 *
 * @author Gakki
 * @date 2018/12/13 - 15:12
 */
public class UserDaoTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SQLSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SQLSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws Exception {
        //6.提交事务
        sqlSession.commit();
        //7.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询一个用户
     */
    @Test
    public void testFindOne() {
        User user = userDao.findOne(53);
        System.out.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByVo(){
        User user = new User();
        user.setUserName("%王%");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        List<User> users = userDao.findByVo(queryVo);
        for (User u : users) {
            System.out.println(u);
        }
    }
    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setUserName("老王");

        List<User> users = userDao.findByCondition(user);
        for (User u : users) {
            System.out.println(u);
        }
    }
}