package com.imugen.design.creational.factory;

/**
 * @author Daniel Liu 2019/9/13 9:14
 */
public class PythonVideoFactory extends VideoFactory {

    @Override
    Video getVideo() {
        return new PythonVideo();
    }
}