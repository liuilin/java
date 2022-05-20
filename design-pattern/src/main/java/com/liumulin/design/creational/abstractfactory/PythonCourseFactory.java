package com.liumulin.design.creational.abstractfactory;

/**
 * @author Daniel Liu 2019/9/21 17:51
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}