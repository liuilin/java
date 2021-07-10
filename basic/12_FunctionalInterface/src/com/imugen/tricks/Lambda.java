package com.imugen.tricks;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Daniel Liu 2020/3/7 18:35
 */
public class Lambda {
    public static void main(String[] args) {
//        Stream<String> strings = Stream.of("Jin", "Mugen", "Fuu");
//        String[] array = strings.toArray(String[]::new);
//        Arrays.asList(array).forEach(System.out::println);
        Arrays.asList(Stream.of("Jin", "Mugen", "Fuu").toArray(String[]::new)).forEach(System.out::println);
    }
}