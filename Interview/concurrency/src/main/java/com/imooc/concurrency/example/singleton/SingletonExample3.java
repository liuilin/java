package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.NotRecommend;
import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * <p>
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 *
 * @author Daniel Liu 2019/12/29 22:27
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造函数
    private SingletonExample3() {

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法
    // 通过添加synchronized关键字，保证线程安全，但是带来了性能的开销（不希望出现的）
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }

}
