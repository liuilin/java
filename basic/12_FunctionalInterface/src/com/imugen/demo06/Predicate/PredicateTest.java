package com.imugen.demo06.Predicate;

import java.util.function.Predicate;

/**
 * @author Daniel Liu 2020/2/20 18:37
 */
public class PredicateTest {
    public static boolean containsString(Predicate<String> one, Predicate<String> two) {
        return one.and(two).test("Jin and Mugen");
    }

    public static void main(String[] args) {
        boolean b = containsString(s -> s.contains("Jin1"), s -> s.contains("Mugen"));
        System.out.println("b = " + b);
    }
}