package com.imooc.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Daniel Liu 2019/12/26 8:32
 */
@Slf4j
public class SynchronizedExample2 {

    /**
     * 修饰一个类
     */
    public void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("{} - {}", j, i);
            }
        }
    }

    /**
     * 修饰静态方法
     */
    public synchronized static void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("{} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        //用线程池开启两个进程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedExample1.test1(1));
        executorService.execute(() -> synchronizedExample2.test1(2));
    }
}