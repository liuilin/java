package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Gakki
 * @date 2018/11/15 - 8:57
 */
public class UserDao {
    /**
     *声明一个成员变量
     */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**登录方法（需要连接池和template模板）
     * @param loginUser 只有用户名和密码
     * @return user的所有信息
     */
    public User login(User  loginUser){
        try {
            //定义sql
            String sql = "select * from user where username=? and password=?";
            //query查询
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
