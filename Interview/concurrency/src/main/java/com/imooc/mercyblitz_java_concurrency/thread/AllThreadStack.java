package com.imooc.mercyblitz_java_concurrency.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * 如何获取当前JVM 所有的现场状态？
 *
 * @author Daniel Liu 2020/1/4 23:21
 */
public class AllThreadStack {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        for (long id : allThreadIds) {
            System.out.println(threadMXBean.getThreadInfo(id));
        }
    }
}