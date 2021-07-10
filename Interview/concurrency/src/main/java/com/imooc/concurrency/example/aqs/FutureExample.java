package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Daniel Liu 2020/1/2 19:32
 */
@Slf4j
public class FutureExample {

    /**
     * callable任务
     */
    private static Callable myCallable = (Callable<String>) () -> {
        log.info("do something with long time");
        //模拟耗时任务
        Thread.sleep(5000);
        return "done";
    };

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(myCallable);
        log.info("do something in main");
        Thread.sleep(1000);
//        String result = (String) future.get();
        //调用Future.get()时，如果任务线程还未执行完毕，则会一直阻塞在此，等待线程任务完成，然后拿到结果
        String result = future.get();
        log.info(result);
        executorService.shutdown();
    }

}