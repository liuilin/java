package com.imugen.mybatis.sqlsession;

/**
 * @author Daniel Liu 2020/2/12 7:18
 */
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
