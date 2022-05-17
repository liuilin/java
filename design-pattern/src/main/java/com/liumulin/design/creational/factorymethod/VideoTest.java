package com.liumulin.design.creational.factorymethod;


/**
 * @author Daniel Liu 2019/9/12 11:24
 */
public class VideoTest {
    /**
     * logger
     */
    public static void main(String[] args) {
        VideoFactory factory = new PythonVideoFactory();
        Video video = factory.getVideo();
        video.produce();
    }
}