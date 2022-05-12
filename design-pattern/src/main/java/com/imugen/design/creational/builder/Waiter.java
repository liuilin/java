package com.imugen.design.creational.builder;

/**
 * @author Daniel Liu 2020/2/11 14:04
 */
public class Waiter {
    private StarbucksBuilder starbucksBuilder;

    public void setStarbucksBuilder(StarbucksBuilder starbucksBuilder) {
        this.starbucksBuilder = starbucksBuilder;
    }
    public Starbucks getStarbucksDrink(){
        return starbucksBuilder.starbucks;
    }
    public void constructStarbucks(){
        starbucksBuilder.creatStarbucks();
        starbucksBuilder.buildSize();
        starbucksBuilder.buildDrink();
    }
}