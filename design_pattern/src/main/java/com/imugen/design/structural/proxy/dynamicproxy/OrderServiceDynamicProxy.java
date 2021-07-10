package com.imugen.design.structural.proxy.dynamicproxy;

import com.imugen.design.structural.proxy.Order;
import com.imugen.design.structural.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Daniel Liu 2019/9/22 16:01
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind(Object target){
        Class cl = target.getClass();
        return Proxy.newProxyInstance(cl.getClassLoader(),cl.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object arg = args[0];
        methodBefore(arg);
        Object o = method.invoke(target, args);
        methodAfter();
        return o;
    }

    private void methodAfter() {
        System.out.println("动态代理after code");
    }

    private void methodBefore(Object arg) {
        System.out.println("动态代理before code");
        if (arg instanceof Order) {
            Order order = (Order) arg;
            int dbRouter = order.getUserId() % 2;
            System.out.println("动态代理分配到【db+"+dbRouter+"数据库】执行数据操作");
            DataSourceContextHolder.setDBType("db"+dbRouter);
        }
    }


}