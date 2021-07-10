package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 指定时间内完成条件
 *
 * @author Daniel Liu 2020/1/1 7:51
 */
@Slf4j
public class CountDownLatchExample2 {
    private static final int threadTotal = 20;

    public static void main(String[] args) throws InterruptedException {
        //定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义闭锁实例
        final CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        for (int i = 0; i < threadTotal; i++) {
            int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("{}", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
            //没有多线程执行超级慢
//            int threadNum = i;
//            test(threadNum);
        }
        countDownLatch.await(5, TimeUnit.MILLISECONDS);
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(200);
        log.info("{}", threadNum);
        Thread.sleep(200);
    }
}