package com.imooc.mercyblitz_java_concurrency;

import java.io.IOException;

/**
 * 如何创建一个进程
 *
 * @author Daniel Liu 2020/1/4 16:42
 */
public class ProcessCreate {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process calc = runtime.exec("calc");
        calc.exitValue();
    }
}