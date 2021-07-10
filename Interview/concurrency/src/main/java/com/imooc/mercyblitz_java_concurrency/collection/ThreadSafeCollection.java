package com.imooc.mercyblitz_java_concurrency.collection;

import java.util.*;

/**
 * 如何将普通 List、Set 以及 Map 转化为线程安全对象？
 *
 * 如何在 Java 9+ 实现以上问题？
 * java 9 的 of 工厂方法，返回 Immutable 对象
 *
 * @author Daniel Liu 2020/1/5 16:29
 */
public class ThreadSafeCollection {
    /*public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2);

        list = List.of(1, 2);
        Set<Integer> set = Set.of(1, 2);
        Map<Integer, String> map = Map.of(0, "hh");
        // 以上实现都是不变对象，不过第一个除外
        // 通过 Collections#sychronized* 方法返回
        // Wrapper 设计模式（所有的方法都被 synchronized 同步或互斥）
        list = Collections.synchronizedList(list);
        set = Collections.synchronizedSet(set);
        map = Collections.synchronizedMap(map);


    }*/
}