package com.tuandai.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liusongrui on 2018/11/23.
 */
public class FixedThreadPoolCase {

    public static void main(String[] args)  throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            //Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("exec:" + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }


}
