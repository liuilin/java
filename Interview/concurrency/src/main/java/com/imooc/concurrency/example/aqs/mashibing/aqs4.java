package com.imooc.concurrency.example.aqs.mashibing;

import java.util.concurrent.locks.Lock;

/**
 * @author Daniel Liu 2020/1/14 18:28
 */
public class aqs4 {
    private static int count;
//        private static Lock lock = new Mutex();
    private static Lock lock = new Mutex1();

    public static void main(String[] args) throws InterruptedException {
//        String[] threads = new String[100];
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
//                add();
                try {
                    lock.lock();
                    for (int j = 0; j < 100; j++) count++;
                } finally {
                    lock.unlock();
                }
            });
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();//等所有子线程运行结束后拿结果
        System.out.println(count);
    }

    private static void add() {
        count++;
    }
}