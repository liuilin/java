package cn.itcast.jedis.test;


import cn.itcast.jedis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;

/**
 * @author Gakki
 * @date 2018/11/29 - 11:28
 */
public class JedisTest {


    /**
     * 快速入门
     */
    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);

        jedis.set("username", "Gakki");

        jedis.close();

    }

    /**
     * string 数据类型
     */
    @Test
    public void test2(){
        //获取连接
        Jedis jedis = new Jedis();
        //操作
        jedis.set("username", "Jin");
        System.out.println(jedis.get("username"));

        jedis.setex("activecode", 10, "Mugen");
        //释放连接
        jedis.close();

    }


    /**
     * hash 数据类型
     */
    @Test
    public void test3(){
        //获取连接
        Jedis jedis = new Jedis();
        //操作
        jedis.hset("user", "name", "Gakki");
        jedis.hset("user", "age", "26");
        jedis.hset("user", "gender", "female");

        System.out.println(jedis.hget("user", "name"));

        //获取hashmap中所有map的数据
        Map<String, String> user = jedis.hgetAll("user");

        Set<String> keySet = user.keySet();

        for (String key : keySet) {
            String value = jedis.get(key);
            System.out.println(key+":"+value);
        }
        //释放连接
        jedis.close();

    }


    /**
     * list 数据类型
     */
    @Test
    public void test4(){
        //获取连接
        Jedis jedis = new Jedis();
        //操作
        jedis.lpush("list", "a", "b", "c");
        jedis.rpush("list", "a", "b", "c");

        System.out.println(jedis.lrange("list", 0, -1));

        jedis.lpop("list");
        jedis.rpop("list");

        System.out.println(jedis.lrange("list", 0, -1));


        //释放连接
        jedis.close();

    }

    /**
     * set 数据类型
     */
    @Test
    public void test5(){
        //获取连接
        Jedis jedis = new Jedis();
        //操作
        jedis.sadd("myset", "Jin", "Mugen", "Fuu");

        System.out.println(jedis.smembers("myset"));


        //释放连接
        jedis.close();

    }
    /**
     * sortedset 数据类型
     */
    @Test
    public void test6(){
        //获取连接
        Jedis jedis = new Jedis();
        //操作
        jedis.zadd("mysortedset", 80, "Jin");
        jedis.zadd("mysortedset", 110, "Mugen");
        jedis.zadd("mysortedset", 100, "Fuu");

        System.out.println(jedis.zrange("mysortedset", 0, -1));

        //释放连接
        jedis.close();

    }
    /**
     * jedisPool
     */
    @Test
    public void test7(){
        //创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //创建连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        Jedis jedis = jedisPool.getResource();
        //操作
        jedis.set("a", "hhh");
        System.out.println(jedis.get("a"));
        //归还连接
        jedis.close();

    }
    /**
     * jedisPoolUtils工具类
     */
    @Test
    public void test8(){
        Jedis jedis = JedisPoolUtils.getJedis();
        //操作
        jedis.set("b", "heihei");
        System.out.println(jedis.get("b"));
        //归还连接
        jedis.close();

    }
}
