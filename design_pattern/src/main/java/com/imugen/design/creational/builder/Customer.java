package com.imugen.design.creational.builder;

/**
 * @author Daniel Liu 2020/2/11 14:24
 */
public class Customer {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        CoffeeBuilder coffeeBuilder = new CoffeeBuilder();
        waiter.setStarbucksBuilder(coffeeBuilder);
        waiter.constructStarbucks();
        System.out.println("waiter.getStarbucksDrink() = " + waiter.getStarbucksDrink());
    }
}