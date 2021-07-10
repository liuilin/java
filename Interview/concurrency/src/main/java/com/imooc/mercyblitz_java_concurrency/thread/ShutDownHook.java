package com.imooc.mercyblitz_java_concurrency.thread;

/**
 * 请说明 ShutdownHook 线程的使用场景，以及如何触发执行？
 * Spring 中 AbstractApplicationContext 的 registerShutdownHook()
 *
 * @author Daniel Liu 2020/1/5 14:17
 */
public class ShutDownHook {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(ShutDownHook::action, "ShutDownHook Q"));
    }

    public static void action() {
        System.out.printf("thread[%s] is running...", Thread.currentThread().getName());
    }
}