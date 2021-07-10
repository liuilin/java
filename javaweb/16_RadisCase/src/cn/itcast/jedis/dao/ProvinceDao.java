package cn.itcast.jedis.dao;

import cn.itcast.jedis.domain.Province;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/11/29 - 19:11
 */
public interface ProvinceDao {
    /**
     * 查询省份
     * @return 省份集合
     */
    List<Province> findProvince();
}
