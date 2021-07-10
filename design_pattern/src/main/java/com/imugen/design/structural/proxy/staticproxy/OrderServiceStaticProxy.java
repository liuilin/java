package com.imugen.design.structural.proxy.staticproxy;

import com.imugen.design.structural.proxy.IOrderService;
import com.imugen.design.structural.proxy.Order;
import com.imugen.design.structural.proxy.OrderServiceImpl;
import com.imugen.design.structural.proxy.db.DataSourceContextHolder;

/**
 * @author Daniel Liu 2019/9/22 12:51
 */
public class OrderServiceStaticProxy {
    private IOrderService iOrderService;
    public void saveOrder(Order order){
        methodBefore(order);
        iOrderService = new OrderServiceImpl();
        iOrderService.saveOrder(order);
        methodAfter();
    }

    private void methodBefore(Order order) {
        int dbRouter = order.getUserId() % 2;
        System.out.println("静态代理分配到【db+"+dbRouter+"数据库】执行数据操作");
        DataSourceContextHolder.setDBType("db"+ dbRouter);
        System.out.println("before code");
    }

    private void methodAfter() {
        System.out.println("after code");
    }
}