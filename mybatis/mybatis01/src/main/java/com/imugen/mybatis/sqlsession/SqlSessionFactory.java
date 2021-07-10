package com.imugen.mybatis.sqlsession;

/**
 * @author Daniel Liu 2020/2/12 7:17
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
