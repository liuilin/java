package com.imugen.design.creational.simplefactory;

/**
 * 简单工厂缺点：添加别的Video种类的时候需要修改Factory类，存在风险，违背了开闭原则
 * 可以通过反射来弥补不足
 * 如果设计为static的，就证明此方法不考虑扩展了
 * 有简单工厂的类：Calendar、DriverManager、
 *
 * @author Daniel Liu 2019/9/12 11:54
 */
public class VideoFactory {
    public Video getVideo(Class type) {
        Video video = null;
        try {
            video = (Video) Class.forName(type.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return video;
    }
/*
    public Video getVideo(String type){
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)) {
            return new PythonVedio();
        }
        return null;
    }
*/
}