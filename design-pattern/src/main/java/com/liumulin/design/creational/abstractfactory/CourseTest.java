package com.liumulin.design.creational.abstractfactory;

/**
 * @author Daniel Liu 2019/9/21 17:46
 */
public class CourseTest {

    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();
    }
}