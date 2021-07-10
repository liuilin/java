package com.imooc.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Daniel Liu 2019/12/26 8:32
 */
@Slf4j
public class SynchronizedExample1 {

    /**
     * 修饰一个代码块
     */
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("{} - {}", j, i);
            }
        }
    }

    /**
     * 修饰方法
     */
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("{} - {}", j, i);
        }
    }

    /*public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        //用线程池开启两个进程
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> {
//            synchronizedExample1.test1();
//        });
        executorService.execute(synchronizedExample1::test1);
        executorService.execute(synchronizedExample1::test2);
    }*/

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        //用线程池开启两个进程
        ExecutorService executorService = Executors.newCachedThreadPool();
        //交替无序执行，由cpu决定
        executorService.execute(() -> synchronizedExample1.test1(1));
        executorService.execute(() -> synchronizedExample2.test1(2));
    }
}