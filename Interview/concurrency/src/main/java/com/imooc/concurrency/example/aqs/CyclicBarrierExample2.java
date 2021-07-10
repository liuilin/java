package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Daniel Liu 2020/1/1 11:08
 */
@Slf4j
public class CyclicBarrierExample2 {

    //定义屏障，制定为5个
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

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
        // 需要异常处理，否则不能进行等待后的代码
        try {
            //等待时间，继续执行，但需要进行异常的捕获，才能继续执行
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            //尽可能捕捉所有的异常类型
            log.warn("BarrierException", e);
        }
        //当到达指定数量之后，继续执行以下代码
        log.info("{} is continue", threadNum);
    }

}