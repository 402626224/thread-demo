package com.tuandai.thread.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by liusongrui on 2018/11/25.
 */
public class FutureTaskCase {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(() -> {
            Thread.sleep(3000);
            System.out.println("这里返回1");
            return 1;
        });

        try {
            new Thread(futureTask).start(); // 这是异步写法
//            futureTask.run(); //           这是同步的写法
            System.out.println("这里执行get");
            System.out.println("==" + futureTask.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
