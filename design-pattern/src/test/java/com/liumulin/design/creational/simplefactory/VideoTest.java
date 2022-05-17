package com.liumulin.design.creational.simplefactory;


import com.liumulin.design.creational.factory.FeVideoFactory;

/**
 * 如果说new JavaVideo的话意味着不同包下需要导包，太依赖这个类了
 *
 * @author Daniel Liu 2019/9/12 11:24
 */
public class VideoTest {
    /**
     * logger
     */
    public static void main(String[] args) {
//        VideoFactory factory = new FeVideoFactory();
//        Video video = factory.getVideo();
//        video.produce();

        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(PythonVideo.class);
        if (video == null) {
            return;
        }
        video.produce();
    }

/*
    public static void main(String[] args) {
//        Video video = new JavaVideo();
        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("python");
        Video video = videoFactory.getVideo(PythonVideo.class);
        if (video == null) {
            return;
        }
        video.produce();
    }
*/
}