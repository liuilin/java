package com.liumulin.design.creational.factory;

/**
 * @author Daniel Liu 2019/9/13 9:14
 */
public class PythonVideoFactory extends VideoFactory {

    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}