package com.imugen.design.creational.builder;

/**
 * @author Daniel Liu 2020/2/11 13:47
 */
public class TeaBuilder extends StarbucksBuilder {
    @Override
    public void buildSize() {
        starbucks.setSize("large");
        System.out.println("build tea large");
    }

    @Override
    public void buildDrink() {
        starbucks.setDrink("tea");
        System.out.println("build tea drink");
    }

}