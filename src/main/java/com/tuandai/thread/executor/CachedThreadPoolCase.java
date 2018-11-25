package com.tuandai.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by liusongrui on 2018/11/23.
 */
public class CachedThreadPoolCase {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {

                    System.out.println("exec:" + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

//        SynchronousQueue synchronousQueue = new SynchronousQueue();
//        new Thread(() -> {
//            try {
//                synchronousQueue.poll(3, TimeUnit.SECONDS);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        Thread.sleep(1000);
//        boolean firstOffer = synchronousQueue.offer("AA");
//
//        System.out.println(firstOffer);
//        firstOffer = synchronousQueue.offer("BB");
//        System.out.println(firstOffer);
    }
}
