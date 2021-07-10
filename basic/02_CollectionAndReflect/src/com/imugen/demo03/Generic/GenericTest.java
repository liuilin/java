package com.imugen.demo03.Generic;

/**
 * @author Daniel Liu 2020/2/19 18:00
 */
class GenericTest {

    public static void main(String[] args) {
//        Generic generic = new Generic();
        Generic<String> generic = new Generic<>();
        generic.setName("hh");
        System.out.println("generic.getName() = " + generic.getName());
    }
}