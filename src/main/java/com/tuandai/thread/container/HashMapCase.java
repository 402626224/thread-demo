package com.tuandai.thread.container;

import java.util.HashMap;
import java.util.UUID;

/**
 * Hash 在多线程竞争下会引起死循环
 * Created by liusongrui on 2018/10/25.
 */
public class HashMapCase {
    /**
     * HashMap 初始化
     */
    public void hashMapInit() {


    }

    /**
     * HashMap 多线程环境下 死循环
     */
    public void hashMapMultiThreading() throws InterruptedException {
        final HashMap<String, String> hashMap = new HashMap();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            hashMap.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();

//        Thread.sleep(3000);
//        System.out.println(hashMap.keySet().size());
    }

    public static void main(String[] args) throws InterruptedException {


    }


}
