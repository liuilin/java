package com.liumulin.design.creational.factorymethod;

/**
 * @author Daniel Liu 2019/9/12 11:16
 */
public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制 Java 视频");
    }
}