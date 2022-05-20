package com.liumulin.design.creational.factorymethod2;

/**
 * 卡车
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("卡车陆运");
    }
}
