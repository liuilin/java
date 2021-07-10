package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Daniel Liu 2020/1/2 19:47
 */
@Slf4j
public class FutureTaskExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("do something with long time");
            Thread.sleep(5000);
            return "done";
        });
        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        if (!futureTask.isDone()) {
            log.info("thread not done!");
            Thread.sleep(1000);
        }
        String result = futureTask.get();
        log.info(result);
    }
}