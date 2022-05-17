package com.imugen.design.creational.simplefactory;

/**
 * @author Daniel Liu 2019/9/12 11:22
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("python 视频");
    }
}