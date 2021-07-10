package com.imugen.demo01.Object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo02Equals {
    public static void main(String[] args) {
        /*
            Person类默认继承了Object类,所以可以使用Object类的equals方法
            boolean equals(Object obj) 指示其他某个对象是否与此对象“相等”。
            equals方法源码:
                public boolean equals(Object obj) {
                    return (this == obj);
                }
                参数:
                    Object obj:可以传递任意的对象
                    == 比较运算符,返回的是一个布尔值 true false
                    基本数据类型:比较的是值
                    引用数据类型:比价的是两个对象的地址值
               this是谁?那个对象调用的方法,方法中的this就是那个对象;p1调用的equals方法所以this就是p1
               obj是谁?传递过来的参数p2
               this==obj -->p1==p2
         */
        Person p1 = new Person("迪丽热巴", 18);
        //Person p2 = new Person("古力娜扎",19);
//        Person p2 = new Person("迪丽热巴",18);
        Person p2 = null;
        System.out.println("p1:" + p1);//p1:com.itheima.demo01.Object.Person@58ceff1
        System.out.println("p2:" + p2);//p2:com.itheima.demo01.Object.Person@7c30a502

        //p1=p2;//把p2的地址值赋值给p1
//        ArrayList<String> list = new ArrayList<>();

        boolean b = p1.equals(p1);
        System.out.println(b);
//        Collection<String> coll = new ArrayList<>();
        List<String> coll = new ArrayList<>();
        coll.add("a");
        coll.add("b");
        Iterator<String> iterator = coll.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
/*
        for (String s : coll) {
//            System.out.println("s = " + s);
//            if (s==coll.get(0)) {
                String s1 = coll.get(0);
//                System.out.println("coll.get(0) = " + s1);
//            }
            System.out.println("s1 = " + s1);
            return;
        }
*/
//        Stream.of(coll).forEach(System.out::println);
//        for (int i = 0; i < coll.size(); i++) {
//            String s = coll.get(i);
//            System.out.println("s = " + s);
//        }
//        IntStream.range(0, coll.size()).forEach(i-> System.out.println(coll.get(i)));
    }
}
