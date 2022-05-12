package com.imugen.design.creational.factory;

/**
 * @author Daniel Liu 2019/9/13 9:13
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    Video getVideo() {
        return new JavaVideo();
    }
}