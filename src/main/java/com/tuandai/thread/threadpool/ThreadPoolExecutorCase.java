package com.tuandai.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;

/**
 * 线程池创建
 * Created by liusongrui on 2018/11/21.
 */
public class ThreadPoolExecutorCase {
    /**
     * 线程池的基本大小 ， 调用prestartAllCoreThreads() 方法，线程池会提前创建并启动所有基本线程
     */
    static final int corePoolSize = 5;
    /**
     *
     */
    static final int maximumPoolSize = 5;

    static final int keepAliveTime = 5;
    static final int unit = 5;
    /**
     * 任务队列：用于保存等待执行的任务的阻塞队列
     */
    BlockingQueue runnableTaskQueue = new ArrayBlockingQueue(10);
    ThreadFactory threadFactory;
    RejectedExecutionHandler handler;


    public static void main(String[] args) {
        /**
         ThreadPoolExecutor(int corePoolSize,
         int maximumPoolSize,
         long keepAliveTime,
         TimeUnit unit,
         BlockingQueue<Runnable> workQueue,
         ThreadFactory threadFactory,
         RejectedExecutionHandler handler)
         */
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_SIZE, CORE_SIZE, 1, );
    }

}
