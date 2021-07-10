package com.imugen.design.creational.factory;

/**
 * @author Daniel Liu 2019/9/13 9:36
 */
public class FeVideoFactory extends VideoFactory {
    @Override
    Video getVideo() {
        return new FeVideo();
    }
}