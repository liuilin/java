package cn.itcast.jedis.service;

import cn.itcast.jedis.domain.Province;

import java.util.List;

/**
 * @author Gakki
 */
public interface ProvinceService {
    /**查询省份
     * @return 省份集合
     */
    List<Province> findProvince();

    /**
     *
     * @return json字符串
     */
    String findJson();
}
