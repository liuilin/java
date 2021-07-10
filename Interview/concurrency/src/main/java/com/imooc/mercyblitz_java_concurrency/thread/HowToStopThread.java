package com.imooc.mercyblitz_java_concurrency.thread;

/**
 * 如何停止一个线程？【想要停止一个线程是不可能的，真正的只能停止逻辑。】
 * <p>
 * 为什么 Java 要放弃 Thread 的 stop()方法？
 * Because it is inherently unsafe. Stopping a thread causes it to unlock all the monitors that it has locked.
 * 简单的说，防止死锁，以及状态不一致的情况出现。
 *
 * 请说明 Thread interrupt()、isInterrupted() 以及 interrupted()的区别以及意义？（看源码）
 * Thread interrupt()： 设置状态，调JVM的本地（native）interrupt0()方法。
 * isInterrupted()： 调的是静态方法isInterrupted(),当且仅当状态设置为中断时，返回false，并不清除状态。
 * interrupted()： 私有本地方法，即判断中断状态，又清除状态。
 * @author Daniel Liu 2020/1/4 18:56
 */
public class HowToStopThread {
    public static void main(String[] args) throws InterruptedException {
        //屌丝方案一
//        Action action = new Action();
//        Thread thread = new Thread(action,"t1");
//        thread.start();
//        action.setStopped(true);
//        thread.join();

        //推荐方案二
        Thread t2 = new Thread(() -> {
            if (!Thread.currentThread().isInterrupted()) {
                action();
            }
        }, "t2");
        t2.start();
        t2.interrupt();
        t2.join();
    }

    private class Action implements Runnable {
        //开关，有线程安全问题，需要加volatile[happens-before]
        public volatile boolean stopped = false;

        public void setStopped(boolean stopped) {
            this.stopped = stopped;
        }

        @Override
        public void run() {
            if (!stopped) {
                action();
            }
        }

    }

    public static void action() {
        System.out.printf("thread[%s] is running...", Thread.currentThread().getName());
    }
}