package com.imugen.design.structural.proxy.dynamicproxy;

import com.imugen.design.structural.proxy.IOrderService;
import com.imugen.design.structural.proxy.Order;
import com.imugen.design.structural.proxy.OrderServiceImpl;

/**
 * @author Daniel Liu 2019/9/22 16:25
 */
public class Test {
    private IOrderService iOrderService;

    public static void main(String[] args) {
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind(new OrderServiceImpl());
        Order order = new Order();
        order.setUserId(2);
        orderServiceDynamicProxy.saveOrder(order);
    }
}