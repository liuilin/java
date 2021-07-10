package com.imugen.design.creational.builder;

/**
 * @author Daniel Liu 2020/2/11 13:44
 */
public abstract class StarbucksBuilder {
    protected Starbucks starbucks;

    public Starbucks getStarbucks() {
        return starbucks;
    }

    public void creatStarbucks() {
        starbucks = new Starbucks();
        System.out.println("a drink is created");
    }

    public abstract void buildSize();

    public abstract void buildDrink();
}