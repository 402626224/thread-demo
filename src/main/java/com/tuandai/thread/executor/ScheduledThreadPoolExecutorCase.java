package com.tuandai.thread.executor;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liusongrui on 2018/11/23.
 */
public class ScheduledThreadPoolExecutorCase {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        /**
         * schedule : 进行一次延迟调度

         * scheduleAtFixedRate : 每次依照上一次预计调度时间进行调度(如果超过下次执行时间，那么接下来计算的时间会优先计算进去)
             hello :2018-11-23 15:27:32
             end   :2018-11-23 15:27:35
             hello :2018-11-23 15:27:35
             end   :2018-11-23 15:27:38
             hello :2018-11-23 15:27:38
             end   :2018-11-23 15:27:41
             hello :2018-11-23 15:27:41

         * scheduleWithFixedDelay : 按照上一次实际执行完成的时间进行计算下一次时间
             hello :2018-11-23 15:29:36
             end   :2018-11-23 15:29:42
             hello :2018-11-23 15:29:45
             end   :2018-11-23 15:29:51
             hello :2018-11-23 15:29:54
             end   :2018-11-23 15:30:00
         */

//        executorService.scheduleAtFixedRate(() -> {
//            try {
//                System.out.println("hello :" + LocalDateTime.now());
//                Thread.sleep(3000);
//                System.out.println("end   :" + LocalDateTime.now());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, 0, 2, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(() -> {
            try {
                System.out.println("hello :" + LocalDateTime.now());
                Thread.sleep(6000);
                System.out.println("end   :" + LocalDateTime.now());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS);


    }

}
