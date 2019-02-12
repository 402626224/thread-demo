package com.tuandai.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by liusongrui on 2018/11/28.
 */
public class FutureTaskCase {


    public static void main(String[] args) throws InterruptedException {
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            FutureTask<Integer> futureTask = new FutureTask<Integer>(new ComputeTask());
            futureTasks.add(futureTask);
            pool.submit(futureTask);
        }

        System.out.println("所有任务提交完毕，主线程接着执行");
        System.out.println("主线程打DOTA2中。。。。");
        //睡眠5秒，模拟主线程执行其他逻辑
        Thread.sleep(5000);
        System.out.println("主线程DOTA2游戏结束，开始统计任务执行结果");
        //用于打印任务执行结果

        Integer result = 0;
        for (FutureTask<Integer> task : futureTasks) {
            try {
                //FutureTask的get()方法会自动阻塞，知道得到任务执行结果为止
                result += task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //关闭线程池
        pool.shutdown();
        System.out.println("多线程多任务执行结果：" + result);

    }

    static class ComputeTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int random = new Random().nextInt(10);
            System.out.println(random);
            return 1;
        }
    }
}
