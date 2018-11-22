package com.tuandai.thread.threadpool;

import java.util.concurrent.*;

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
     * 线程池最大数量
     */
    static final int maximumPoolSize = 10;
    /**
     * 线程活动保持时间
     */
    static final long keepAliveTime = 5;
    /**
     * 线程活动保持时间的单位
     */
    static final TimeUnit unit = TimeUnit.SECONDS;
    /**
     * 任务队列：用于保存等待执行的任务的阻塞队列
     * runnableTaskQueue = new ArrayBlockingQueue(10);// 基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序
     * runnableTaskQueue = new LinkedBlockingQueue();// 基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量通常要高于 ArrayBlockingQueue ，
     * 静态工厂方法 Executors.newFixedThreadPool(10); 使用了这个队列
     * runnableTaskQueue = new SynchronousQueue(); // 一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，
     * 吞吐量通常要高于 LinkedBlockingQueue ，静态工厂方法 Executors.newCachedThreadPool(); 使用了这个队列
     * runnableTaskQueue = new PriorityBlockingQueue(); // 一个具有优先级的无限阻塞队列
     */
    static BlockingQueue runnableTaskQueue = new ArrayBlockingQueue(10);

    /**
     * 用于设置创建线程的工厂
     */
    static ThreadFactory threadFactory;

    /**
     * 饱和策略
     * handler  = new ThreadPoolExecutor.AbortPolicy(); // 直接抛出异常
     * handler = new ThreadPoolExecutor.CallerRunsPolicy(); // 只用调用者所在线程来运行任务
     * handler = new ThreadPoolExecutor.DiscardOldestPolicy(); // 丢弃队列里最近的一个任务，并执行当前任务
     * handler = new ThreadPoolExecutor.DiscardPolicy(); // 不处理，丢弃掉
     */
    static RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();


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
        threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, runnableTaskQueue, threadFactory, handler);

        threadPoolExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " exec ");
        });

        Future<String> future = threadPoolExecutor.submit(() -> {
            System.out.println("aaaaaaaaaaaaa");
            return "a";
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }

    }

}
