package com.liumulin.design.creational.factorymethod2;

/**
 * 飞机
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class Plane implements Transport {
    @Override
    public void deliver() {
        System.out.println("飞机运送");
    }
}
