package com.imugen.design.structural;

import com.imugen.design.structural.proxy.IOrderService;
import com.imugen.design.structural.proxy.Order;
import com.imugen.design.structural.proxy.OrderServiceImpl;
import org.junit.Test;

/**
 * @author Daniel Liu 2019/9/22 11:36
 */
public class OrderServiceImplTest {
    private IOrderService iOrderService;

    @Test
    public void saveOrder() {
        iOrderService = new OrderServiceImpl();
        Order o = new Order();
        o.setUserId(1);
        int i = iOrderService.saveOrder(o);
    }
}