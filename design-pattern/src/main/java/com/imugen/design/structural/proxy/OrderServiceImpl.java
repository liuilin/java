package com.imugen.design.structural.proxy;

/**
 * @author Daniel Liu 2019/9/22 11:30
 */
public class OrderServiceImpl implements IOrderService {
    private IOrderDao orderDao;
    @Override
    public int saveOrder(Order order) {
        IOrderDao iOrderDao = new OrderDaoImpl();
        return iOrderDao.insert(order);
    }
}