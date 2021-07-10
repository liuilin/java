package com.atguigu.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Daniel Liu 2020/1/15 12:42
 */
class myData {
    volatile int num = 0;

    public void toNum() {
        num = 60;
    }
}

public class VolatileDemo {

    public static void main(String[] args) {
        myData myData = new myData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\tcoming thread");
            //暂停一会儿线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.toNum();
            System.out.println(Thread.currentThread().getName() + "\tupdate num to:" + myData.num);
        }, "thread1").start();

        //第二个线程就是我们的main线程
        while (myData.num == 0) {
            //main线程就在这一直等待，知道num不再等于0
        }
        System.out.println("mission complete,main get num:" + myData.num);
    }
}