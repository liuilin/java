package com.imugen.dao;

import com.imugen.domain.User;
import com.imugen.util.DbUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Daniel Liu 2020/1/16 8:25
 */
public class LoginDao {
    private JdbcTemplate jt = new JdbcTemplate(DbUtils.getDataSource());

    public User login(User user) {
        try {
            String sql = "select * from user where name=? and password =?";
            return jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getName(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}