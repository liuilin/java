package com.imooc.mercyblitz_java_concurrency.thread;

/**
 * 如何确保主线程退出前，所有线程执行完毕？
 *
 * @author Daniel Liu 2020/1/5 16:02
 */
public class CompleteAllThreads {
    public static void main(String[] args) {
        // main 线程 -> 子线程
        Thread t1 = new Thread(CompleteAllThreads::action, "t1");
        Thread t2 = new Thread(CompleteAllThreads::action, "t2");
        Thread t3 = new Thread(CompleteAllThreads::action, "t3");

        // 不确定 t1、t2、t3 是否调用 start()
        t1.start();
        t2.start();
        t3.start();
        // 创建了 N Thread

        // 获取 main 线程组
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        // 活跃的线程数
        int activeCount = threadGroup.activeCount();
        Thread[] threads = new Thread[activeCount];
        // 把所有的线程复制 threads 数组
        threadGroup.enumerate(threads, true);

        for (Thread thread : threads) {
            System.out.printf("currently active thread[%s]\n", thread.getName());
        }
    }

    public static void action() {
        System.out.printf("thread[%s] is running\n", Thread.currentThread().getName());
    }
}