package com.imugen.mybatis.sqlsession;

import com.imugen.domain.Mapper;
import com.imugen.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * 对dao接口增强，以实现不写实现类进行增删改
 *
 * @author Daniel Liu 2020/2/12 7:50
 */
public class MapperFactory implements InvocationHandler {
    private Map<String,Mapper> mappers;
    private Connection conn;

    public MapperFactory(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 对代理方法增强，也就是调用了selectList方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        Mapper mapper = mappers.get(className + "." + methodName);
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误，无法获取执行的必要条件");
        }
        return new Executor().selectList(mapper, conn);
    }
}