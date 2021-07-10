package cn.itcast.jedis.service.impl;

import cn.itcast.jedis.dao.ProvinceDao;
import cn.itcast.jedis.dao.impl.ProvinceDaoImpl;
import cn.itcast.jedis.domain.Province;
import cn.itcast.jedis.service.ProvinceService;
import cn.itcast.jedis.utils.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/11/29 - 19:12
 */
public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao = new ProvinceDaoImpl();

    @Override
    public List<Province> findProvince() {
        return provinceDao.findProvince();
    }

    @Override
    public String findJson() {
        //1.先从redis中查询数据
        //1.1获取连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String provinceJson = jedis.get("province");

        //2.判断provinceJson数据是否为null
        if (provinceJson == null || provinceJson.length() == 0) {
            //redis中没数据
            System.out.println("redis中没数据，查询数据库");
            //2.1从数据库中查
            List<Province> list = provinceDao.findProvince();
            //2.2序列化list为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                provinceJson = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //3.将json数据存入redis
            jedis.set("province", provinceJson);
            jedis.close();

        } else {
            System.out.println("redis有数据，查询缓存");
        }
        return provinceJson;
    }

}
