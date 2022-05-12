package com.imugen.design.creational.abstractfactory;

/**
 * @author Daniel Liu 2019/9/21 17:50
 */
public class FeArticle extends Article {
    @Override
    void produce() {
        System.out.println("Fe diary");
    }
}