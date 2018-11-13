package com.tuandai.thread.concurrenttool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier 实现场景
 * 银行流水处理服务类
 * Created by liusongrui on 2018/11/13.
 */
public class BankWaterService implements Runnable {

    /**
     * 创建4个屏障，处理完之后执行当前类的run 方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);
    /**
     * 假设只有 4 个 sheet，所以只启动 4 个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);
    /**
     * 保存每个 sheet 计算出来的银流结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                //计算银流，计算代码省略
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    //银流完成，插入一个屏障
                    c.await();
                    System.out.println(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        //汇总每个 sheet 计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
