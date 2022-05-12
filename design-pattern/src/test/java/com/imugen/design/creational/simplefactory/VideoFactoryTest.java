package com.imugen.design.creational.simplefactory;

import org.junit.Test;

/**
 * @author Daniel Liu 2019/9/21 16:57
 */
public class VideoFactoryTest {
    VideoFactory videoFactory = new VideoFactory();

    @Test
    public void testGetVideo() throws Exception {
        Video result = videoFactory.getVideo(JavaVideo.class);
        if (result == null) {
            return;
        }
        result.produce();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme