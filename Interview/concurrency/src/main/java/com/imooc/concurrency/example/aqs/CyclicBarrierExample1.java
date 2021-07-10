package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Daniel Liu 2020/1/1 11:08
 */
@Slf4j
public class CyclicBarrierExample1 {

    //定义屏障，制定为5个
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //往线程池中放入10个线程
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(10000);
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
        //如果当前线程就绪，则告诉CyclicBarrier 需要等待
        cyclicBarrier.await();
        //当到达指定数量之后，继续执行以下代码
        log.info("{} is continue", threadNum);
    }

}