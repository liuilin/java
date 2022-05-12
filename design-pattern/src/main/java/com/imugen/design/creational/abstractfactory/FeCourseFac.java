package com.imugen.design.creational.abstractfactory;

/**
 * @author Daniel Liu 2019/9/21 17:51
 */
public class FeCourseFac implements CourseFactory {
    @Override
    public Video getVideo() {
        return new FeVideo();
    }

    @Override
    public Article getArticle() {
        return new FeArticle();
    }
}