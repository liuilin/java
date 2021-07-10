package com.imugen.mybatis.sqlsession;

import com.imugen.domain.Configuration;
import com.imugen.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author Daniel Liu 2020/2/12 7:16
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据流配置流构建一个SQLsession工厂
     * @param is
     * @return
     */
    public SqlSessionFactory build(InputStream is) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(is);
        return new DefaultSqlSessionFactory(cfg);
    }
}