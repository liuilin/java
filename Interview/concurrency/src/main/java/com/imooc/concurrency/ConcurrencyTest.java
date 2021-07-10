package com.imooc.concurrency;

import com.imooc.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Daniel Liu 2019/12/25 8:38
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {
    /**
     * 请求总数
     */
    private static final int clientTotal = 5000;

    /**
     * 同时并发执行的线程数
     */
    private static final int threadTotal = 200;

    /**
     * 计数器
     */
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("count:{}",count);
        executorService.shutdown();
    }

    private static void add() {
        count++;
    }
}