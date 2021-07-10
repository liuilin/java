package com.imooc.concurrency.example.count;

import com.imooc.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加了Atomic原子包的线程安全写法
 *
 * @author Daniel Liu 2019/12/25 8:38
 */
@Slf4j
@ThreadSafe
public class CountExample2 {
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
    private static AtomicInteger count = new AtomicInteger(0);

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
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("count:{}", count.get());
//        System.out.println(count.get());
        executorService.shutdown();
    }

    private static void add() {
        //没有返回值，所以无需考虑++i还是i++
        count.getAndIncrement();
//        count.incrementAndGet();
    }
}