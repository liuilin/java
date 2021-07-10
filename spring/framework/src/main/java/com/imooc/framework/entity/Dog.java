package com.imooc.framework.entity;

import org.springframework.stereotype.Component;

/**
 * @author Daniel Liu 2020/2/16 14:35
 */
@Component
public class Dog implements Pet {
    @Override
    public void move() {
        System.out.println("dog running");
    }
}