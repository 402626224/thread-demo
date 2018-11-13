package com.tuandai.thread.concurrenttool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程间交换数据的 Exchanger
 * Created by liusongrui on 2018/11/13.
 */
public class ExchangerCase {

    public static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            try {
                String A = "银行流水A";
                String B = exgr.exchange(A);
                System.out.println("A:" + A + ",B:" + B);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            try {
                String B = "银行流水B";
                String A = exgr.exchange(B);
                System.out.println("B:" + B + ",A:" + A);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        threadPool.shutdown();
    }

}
