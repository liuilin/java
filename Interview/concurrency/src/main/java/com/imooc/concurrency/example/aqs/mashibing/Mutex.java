package com.imooc.concurrency.example.aqs.mashibing;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 这本质还是调用的Synchronized，在Mutex1中优化
 *
 * @author Daniel Liu 2020/1/14 19:06
 */
public class Mutex implements Lock {
    private volatile Integer i = 0;

    @Override
    public void lock() {
        synchronized (this) {
            while (i != 0) {//已有线程占用
                try {
                    this.wait();//阻塞 CAS（用自旋也可以）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i = 1;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this) {
            i = 0;//当前线程已经执行完
            this.notifyAll();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}