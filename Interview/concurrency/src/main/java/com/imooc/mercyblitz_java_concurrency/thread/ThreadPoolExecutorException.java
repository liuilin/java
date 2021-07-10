package com.imooc.mercyblitz_java_concurrency.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 当线程遇到异常时，ThreadPoolExecutor 如何捕获异常？
 *
 * @author Daniel Liu 2020/1/4 22:15
 */
public class ThreadPoolExecutorException {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.printf("thread[%s] was encountered exception，detail:%s\n", Thread.currentThread().getName(), throwable.getMessage());
        });
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>()) {
            /**
             * 通过覆盖{@link ThreadPoolExecutor#afterExecute(Runnable, Throwable)}达到获取异常信息
             * 不建议使用，捕捉到之后还会抛异常。用前一种方法
             *
             * @param r
             * @param t
             */
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
//                System.out.printf("thread[%s] was encountered exception，detail:%s\n", Thread.currentThread().getName(), t.getMessage());
            }
        };
        threadPoolExecutor.execute(() -> {
            throw new RuntimeException("数据达到阈值");
        });
        threadPoolExecutor.awaitTermination(1, TimeUnit.SECONDS);
        threadPoolExecutor.shutdown();
    }
}