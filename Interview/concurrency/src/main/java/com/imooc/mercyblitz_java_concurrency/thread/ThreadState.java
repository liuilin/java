package com.imooc.mercyblitz_java_concurrency.thread;

/**
 * 如何销毁一个线程？
 * Java代码中是无法实现的，只能表现一个线程的状态。
 * 而CPP是可以实现的。
 *
 * @author Daniel Liu 2020/1/4 17:38
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.printf("thread[%s] is running\n",Thread.currentThread().getName());
        }, "sub thread-1");

        thread.start();
        //先于Runnable执行
        System.out.printf("thread[%s] is alive:%s\n",thread.getName(),thread.isAlive());
        //在java中执行线程，java是无法销毁它的
        //但是当Thread.isAlive()返回false的时，实际底层Thread已经被销毁了
    }

}