package com.liumulin.design.creational.factorymethod2;

/**
 * 空运工厂类
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class AirLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Plane();
    }
}
