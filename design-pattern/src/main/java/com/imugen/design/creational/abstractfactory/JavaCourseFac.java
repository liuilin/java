package com.imugen.design.creational.abstractfactory;

/**
 * @author Daniel Liu 2019/9/21 17:45
 */
public class JavaCourseFac implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}