package cn.itcast.jedis.dao.impl;

import cn.itcast.jedis.dao.ProvinceDao;
import cn.itcast.jedis.domain.Province;
import cn.itcast.jedis.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/11/29 - 19:10
 */
public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findProvince() {
        //定义sql
        String sql = "select * from province";
        List<Province> provinces = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        System.out.println(provinces);
        return provinces;
    }
}
