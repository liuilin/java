package com.liumulin.design.creational.factorymethod2;

/**
 * @author liuqiang
 * @since 2022-05-20
 */
public class LogisticsTest {
    public static void main(String[] args) {
        Logistics logistics = new SeaLogistics();
        Transport transport = logistics.createTransport();
        transport.deliver();
    }
}
