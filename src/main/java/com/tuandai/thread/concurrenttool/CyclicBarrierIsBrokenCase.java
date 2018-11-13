package com.tuandai.thread.concurrenttool;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 中断测试  isBroken() 方法用来了解阻的塞线程是否被中断
 * Created by liusongrui on 2018/11/13.
 */
public class CyclicBarrierIsBrokenCase {

    public static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread.interrupt();

        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
            e.printStackTrace();
        }
    }


}
