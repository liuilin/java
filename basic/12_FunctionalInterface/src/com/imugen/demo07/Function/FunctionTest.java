package com.imugen.demo07.Function;

import java.util.function.Function;

/**
 * @author Daniel Liu 2020/2/20 18:45
 */
public class FunctionTest {
    //1. 将字符串截取数字年龄部分，得到字符串；
    //2. 将上一步的字符串转换成为int类型的数字；
    //3. 将上一步的int数字累加100，得到结果int数字
    public static Integer handleString(Function<String, String> one, Function<String, Integer> two, Function<Integer, Integer> three, String str) {
        return one.andThen(two).andThen(three).apply(str);
    }

    public static void main(String[] args) {
        String str = "赵丽颖,20";
        Integer integer = handleString(s -> s.split(",")[1], Integer::valueOf, s -> s + 100, str);
        System.out.println("integer = " + integer);
    }
}