package com.liumulin.design.creational.factorymethod2;

/**
 * 轮船
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("轮船海运");
    }
}
