package com.imooc.mercyblitz_java_concurrency.thread;

/**
 * 当有线程 T1、T2 以及 T3，如何实现 T1 -> T2 -> T3 的执行顺序？
 * 以上问题请至少提供另外一种实现？
 *
 * @author Daniel Liu 2020/1/4 17:52
 */
public class ThreadExecution {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(ThreadExecution::action, "t1");
        Thread t2 = new Thread(ThreadExecution::action, "t2");
        Thread t3 = new Thread(ThreadExecution::action, "t3");

        threadWait(t1);
        threadWait(t2);
        threadWait(t3);
    }

    private static void threadWait(Thread t1) throws InterruptedException {
        if (Thread.State.NEW.equals(t1.getState())) {
            t1.start();
        }
        while (t1.isAlive()) {
            synchronized (t1) {
                t1.wait();
                // 到底是谁通知 Thread -> thread.notify();  JVM帮它唤起
                // LockSupport.park();
                // 死锁发生
            }
        }
    }

    private static void sleep() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecution::action, "t1");
        Thread t2 = new Thread(ThreadExecution::action, "t2");
        Thread t3 = new Thread(ThreadExecution::action, "t3");

        t1.start();
        while (t1.isAlive()) {
            //sleep
            Thread.sleep(0);
        }
        t2.start();
        while (t2.isAlive()) {
            Thread.sleep(0);
        }
        t3.start();
        while (t3.isAlive()) {
            Thread.sleep(0);
        }
    }

    private static void spin() {
        Thread t1 = new Thread(ThreadExecution::action, "t1");
        Thread t2 = new Thread(ThreadExecution::action, "t2");
        Thread t3 = new Thread(ThreadExecution::action, "t3");

        t1.start();
        while (t1.isAlive()) {
            //自旋
        }
        t2.start();
        while (t2.isAlive()) {

        }
        t3.start();
        while (t3.isAlive()) {

        }
    }

    private static void threadJoinOneByOne() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecution::action, "t1");
        Thread t2 = new Thread(ThreadExecution::action, "t2");
        Thread t3 = new Thread(ThreadExecution::action, "t3");

        //start()仅是通知线程执行
        t1.start();
        //join()控制线程必须执行完成
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }

    public static void action() {
        System.out.printf("thread[%s] is running...\n", Thread.currentThread().getName());
    }
}