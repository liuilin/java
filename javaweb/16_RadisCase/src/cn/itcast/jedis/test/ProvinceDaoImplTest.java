package cn.itcast.jedis.test;

import cn.itcast.jedis.dao.ProvinceDao;
import cn.itcast.jedis.dao.impl.ProvinceDaoImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author Gakki
 * @date 2018/11/29 - 19:39
 */
public class ProvinceDaoImplTest {
    @Test
    public void findProvince() {
        ProvinceDao provinceDao = new ProvinceDaoImpl();
        provinceDao.findProvince();
    }
}
