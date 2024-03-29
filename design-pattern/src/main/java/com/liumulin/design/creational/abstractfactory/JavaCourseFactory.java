package com.liumulin.design.creational.abstractfactory;

/**
 * Java 课程工厂
 *
 * @author Daniel Liu 2019/9/21 17:45
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}