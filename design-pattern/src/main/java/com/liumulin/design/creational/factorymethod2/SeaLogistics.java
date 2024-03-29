package com.liumulin.design.creational.factorymethod2;

/**
 * 海运工厂类
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
