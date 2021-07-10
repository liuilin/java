package com.imugen.mybatis.sqlsession;

import com.imugen.domain.Configuration;

/**
 * @author Daniel Liu 2020/2/12 7:22
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}