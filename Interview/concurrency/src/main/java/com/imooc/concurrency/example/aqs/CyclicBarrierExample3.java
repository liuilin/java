package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 带回调函数
 *
 * @author Daniel Liu 2020/1/1 11:08
 */
@Slf4j
public class CyclicBarrierExample3 {

    //定义屏障，制定为5个
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> log.info("cyclicBarrier is running..."));

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //往线程池中放入10个线程
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("{}", e);
                }
            });
        }
        log.info("finish");
        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        cyclicBarrier.await();
        //当到达指定数量之后，继续执行以下代码
        log.info("{} is continue", threadNum);
    }

}