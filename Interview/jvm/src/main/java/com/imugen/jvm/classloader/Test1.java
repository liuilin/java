package com.imugen.jvm.classloader;

/**
 * 对于静态字段，只有直接定义了该字段的类才会被初始化
 * 当一个类初始化完毕时，要求其父类全部初始化完毕（因为java是单继承的，父类会要求父类继续初始化，直到Object。每个类只能被初始化一次）
 *
 * @author Daniel Liu 2020/1/10 16:55
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Child1.str1);
    }
}

class Parent1 {
    public static String str = "hello world";

    static {
        System.out.println("parent execute");
    }
}

class Child1 extends Parent1 {
    public static String str1 = "lalala";

    static {
        System.out.println("child execute");
    }

}