package com.tuandai.thread.concurrenttool;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by liusongrui on 2018/11/12.
 */
public class CyclicBarrierCase {

    //屏障拦截的线程数
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("1");
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("2");
    }

    static class A implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("3");
        }
    }

}
