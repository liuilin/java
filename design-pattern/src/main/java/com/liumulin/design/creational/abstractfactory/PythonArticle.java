package com.liumulin.design.creational.abstractfactory;

/**
 * @author Daniel Liu 2019/9/21 17:50
 */
public class PythonArticle extends Article {
    @Override
    void produce() {
        System.out.println("python article");
    }
}