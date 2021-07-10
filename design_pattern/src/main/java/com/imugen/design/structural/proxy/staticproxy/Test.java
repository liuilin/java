package com.imugen.design.structural.proxy.staticproxy;

import com.imugen.design.structural.proxy.Order;

/**
 * @author Daniel Liu 2019/9/22 13:10
 */
public class Test {

    public static void main(String[] args) {
        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        Order order = new Order();
        order.setUserId(1);
        orderServiceStaticProxy.saveOrder(order);
    }
}