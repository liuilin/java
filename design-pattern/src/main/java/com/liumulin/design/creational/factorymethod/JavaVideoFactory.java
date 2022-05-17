package com.liumulin.design.creational.factorymethod;

/**
 * @author Daniel Liu 2019/9/13 9:13
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}