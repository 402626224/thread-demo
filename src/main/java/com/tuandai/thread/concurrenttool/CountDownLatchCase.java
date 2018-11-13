package com.tuandai.thread.concurrenttool;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 主线程等待所有线程完成
 * Created by liusongrui on 2018/11/12.
 */
public class CountDownLatchCase {
    // CountDownLatch 不能重新初始化或者修改 CountDownLatch 对象的内部计数器的值
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(1);
            // CountDownLatch 的 countDown 方法调用时， N 就会减1
            c.countDown();
            System.out.println(2);
            c.countDown();
        });
        thread.start();
        // CountDownLatch 的 await() 方法会阻塞当前线程，直到 N 变成零
        c.await();


    }

}
