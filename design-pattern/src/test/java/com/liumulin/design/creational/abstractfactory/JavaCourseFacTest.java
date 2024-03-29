package com.liumulin.design.creational.abstractfactory;

/**
 * @author Daniel Liu 2019/9/21 17:46
 */
public class JavaCourseFacTest {
    CourseFactory courseFactory = new PythonCourseFactory();

    //    @Test
    public void testGetVideo() throws Exception {
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme