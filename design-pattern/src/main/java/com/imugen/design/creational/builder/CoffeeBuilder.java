package com.imugen.design.creational.builder;

/**
 * @author Daniel Liu 2020/2/11 14:02
 */
public class CoffeeBuilder extends StarbucksBuilder {
    @Override
    public void buildSize() {
        starbucks.setSize("medium");
        System.out.println("build medium");
    }

    @Override
    public void buildDrink() {
        starbucks.setDrink("coffee");
        System.out.println("build drink coffee");
    }
}