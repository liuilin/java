package com.liumulin.design.creational.simplefactory;

/**
 * @author Daniel Liu 2019/9/12 11:22
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制 Python 视频");
    }
}