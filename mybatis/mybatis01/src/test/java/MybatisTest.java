import com.imugen.dao.UserDao;
import com.imugen.mybatis.io.Resources;
import com.imugen.mybatis.sqlsession.SqlSession;
import com.imugen.mybatis.sqlsession.SqlSessionFactory;
import com.imugen.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Gakki
 * @date 2018/12/11 - 21:28
 */
public class MybatisTest {

    /*public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SQLSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂创建SQLSession对象
        SqlSession session = factory.openSession();
        //4.使用SQLSession创建Dao接口代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }*/


    //SqlSessionFactoryBuilder、SqlSessionFactory、SqlSession
    //流程：io读取配置信息，交给构建者，构建者使用工具类构建了一个工厂对象，工厂对象生产SqlSession操作数据库对象，在sqlSession里面创建代理对象和查询所有方法
    @Test
    public void t2() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        sqlSession.close();
        is.close();
        userDao.findAll().forEach(System.out::println);
    }
}
