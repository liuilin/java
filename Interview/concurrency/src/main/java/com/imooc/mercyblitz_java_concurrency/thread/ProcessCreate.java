package com.imooc.mercyblitz_java_concurrency.thread;

import java.io.IOException;

/**
 * 如何通过java创建进程？
 *
 * @author Daniel Liu 2020/1/4 16:42
 */
public class ProcessCreate {
    public static void main(String[] args) throws IOException {
        //获取java runtime
        Runtime runtime = Runtime.getRuntime();
        //执行计算器
//        Process exec = runtime.exec("calc");
        Process exec = runtime.exec("cmd /k start https://www.baidu.com");
        exec.exitValue();
    }
}