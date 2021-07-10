package com.imooc.mercyblitz_java_concurrency.thread;

/**
 * 有哪些方法创建线程？（只有一个new thread）
 * @author Daniel Liu 2020/1/4 16:21
 */
public class ThreadCreate {
    public static void main(String[] args) {
        new Thread(() -> {
        }, "thread");
    }

    /**
     * 不建议自定义扩展
     */
    private static class MyThread extends Thread {
        //多态的方式，覆盖父类实现
        @Override
        public void run() {
            super.run();
        }
    }
}