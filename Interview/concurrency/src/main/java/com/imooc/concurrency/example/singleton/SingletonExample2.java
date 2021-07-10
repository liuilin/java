package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * <p>
 * 缺点：1.若构造方法中存在过多的处理、会导加载缓慢，从而引起性能问题
 * 2.只进行加载，并无实际调用，导致资源浪费
 *
 * @author Daniel Liu 2019/12/29 22:36
 */
@ThreadSafe
public class SingletonExample2 {
    //私有构造
    private SingletonExample2() {
    }

    //单例
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}