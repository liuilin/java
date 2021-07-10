package com.imooc.framework.entity;

import org.springframework.stereotype.Component;

/**
 * @author Daniel Liu 2020/2/16 14:57
 */
@Component
public class Bird implements Pet {
    @Override
    public void move() {
        System.out.println("bird fly");
    }
}