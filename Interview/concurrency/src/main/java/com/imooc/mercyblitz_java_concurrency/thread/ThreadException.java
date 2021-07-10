package com.imooc.mercyblitz_java_concurrency.thread;

/**
 * 当线程遇到异常时，到底发生了什么？
 *
 * @author Daniel Liu 2020/1/4 19:45
 */
public class ThreadException {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler((thread,throwable)->{
            System.out.printf("thread[%s] was encountered exception,detail:%s\n",thread.getName(),throwable.getMessage());
        });

        Thread thread = new Thread(() -> {
            throw new RuntimeException("数据达到阈值");
        }, "t1");

        thread.start();
        //main线程会停止吗
        thread.join();
        System.out.println(thread.isAlive());
    }
}