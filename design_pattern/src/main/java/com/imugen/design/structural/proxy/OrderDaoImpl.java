package com.imugen.design.structural.proxy;

/**
 * @author Daniel Liu 2019/9/22 11:33
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("order inserted");
        return 1;
    }
}