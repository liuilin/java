package com.imooc.mercyblitz_java_concurrency.thread;

import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;

/**
 * 如何获取线程的资源消费情况？
 *
 * @author Daniel Liu 2020/1/4 23:32
 */
public class AllThreadInfo {
    public static void main(String[] args) {
        //换成sun包下的ThreadMXBean
        ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        for (long id : allThreadIds) {
            long bytes = threadMXBean.getThreadAllocatedBytes(id);
            long kBytes = bytes / 1024;
            System.out.printf("thread[ID:%d] allocate memory: %s kb\n",id,kBytes);
        }
    }
}