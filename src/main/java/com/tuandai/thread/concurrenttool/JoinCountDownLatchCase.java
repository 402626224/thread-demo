package com.tuandai.thread.concurrenttool;

/**
 * join() 方法实现 主线程等待所有线程完成
 * <p>
 * Created by liusongrui on 2018/11/12.
 */
public class JoinCountDownLatchCase {

    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(() -> {
            System.out.println("parser1 finish");
        });
        Thread parser2 = new Thread(() -> {
            System.out.println("parser2 finish");
        });

        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();

        System.out.println("all parser finish");

    }

}
