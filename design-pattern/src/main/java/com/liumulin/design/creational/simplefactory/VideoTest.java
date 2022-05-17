package com.liumulin.design.creational.simplefactory;


/**
 * 简单工厂测试类
 *
 * @author Daniel Liu 2019/9/12 11:24
 */
public class VideoTest {
    /**
     * logger
     */
    public static void main(String[] args) {
//        如果用 new JavaVideo 方式的话意味着不同包下需要导包，太依赖这个类了。
//        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("java");
//        if(video == null){
//            return;
//        }
//        video.produce();

        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if (video == null) {
            return;
        }
        video.produce();
    }

}