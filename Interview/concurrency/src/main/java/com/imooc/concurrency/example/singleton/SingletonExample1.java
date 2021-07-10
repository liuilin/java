package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 *
 * @author Daniel Liu 2019/12/29 22:27
 */
@NotThreadSafe
public class SingletonExample1 {

    // 私有构造函数
    private SingletonExample1() {
        //可能这里会存在很多的操作
        //如资源加载、运算等
    }

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态的工厂方法
    // 单线毫无问题
    public static SingletonExample1 getInstance() {
        //多线程环境下存在线程安全问题
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
