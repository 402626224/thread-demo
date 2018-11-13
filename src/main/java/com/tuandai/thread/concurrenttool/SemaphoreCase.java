package com.tuandai.thread.concurrenttool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * Created by liusongrui on 2018/11/13.
 */
public class SemaphoreCase {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("save data");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }


}
