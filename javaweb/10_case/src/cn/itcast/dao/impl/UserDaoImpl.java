package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Gakki
 * @date 2018/11/19 - 17:01
 */
public class UserDaoImpl implements UserDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用jdbc操作数据库
        //定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            //使用jdbc操作数据库
            //定义sql
            String sql = "select * from user where username=? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    username, password);
            return user;
        } catch (DataAccessException e) {
//            e.printStackTrace();//打印错误日志
            return null;
        }
    }

    @Override
    public void add(User user) {
        //定义sql
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAdds(), user.getQq(), user.getEmail());

    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id=?";
        template.update(sql, id);
    }

    @Override
    public User findUser(int id) {
        String sql = "select * from user where id=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=?,gender=?,age=?,adds=?,qq=?,email=? where id=?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAdds(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        List<Object> params = new ArrayList<>();
        //定义参数集合
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断是否有值
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ?");
                params.add("%"+value+"%");
            }
        }

        Integer count = template.queryForObject(sb.toString(), Integer.class,params.toArray());
        return count;
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        List<Object> params = new ArrayList<>();
        //定义参数集合
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断是否有值
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);

        sql = sb.toString();


        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
        return users;
    }
}
