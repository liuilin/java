package com.liumulin.design.creational.factorymethod;

/**
 * @author Daniel Liu 2019/9/13 9:36
 */
public class FeVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new FeVideo();
    }
}