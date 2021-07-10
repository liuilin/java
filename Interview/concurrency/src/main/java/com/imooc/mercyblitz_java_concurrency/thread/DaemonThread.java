package com.imooc.mercyblitz_java_concurrency.thread;

/**
 * 当主线程退出时，守护线程会执行完毕吗？
 * 不一定执行完毕
 * 守候线程的执行依赖于执行时间（非唯一评判）
 *
 * @author Daniel Liu 2020/1/5 14:10
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
//            System.out.println("Hello World!");
            Thread currentThread = Thread.currentThread();
            System.out.printf("线程[name : %s, daemon:%s]: Hello,World\n", currentThread.getName(), currentThread.isDaemon());
        });
        thread.setDaemon(true);
        thread.start();
    }
}