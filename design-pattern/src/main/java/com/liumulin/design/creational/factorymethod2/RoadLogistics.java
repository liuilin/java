package com.liumulin.design.creational.factorymethod2;

/**
 * 陆运工厂类
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
