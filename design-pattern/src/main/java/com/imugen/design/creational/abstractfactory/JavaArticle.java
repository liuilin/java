package com.imugen.design.creational.abstractfactory;

/**
 * @author Daniel Liu 2019/9/21 17:44
 */
public class JavaArticle extends Article {
    @Override
    void produce() {
        System.out.println("java diary");
    }
}