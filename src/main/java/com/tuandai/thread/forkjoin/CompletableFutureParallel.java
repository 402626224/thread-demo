package com.tuandai.thread.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liusongrui on 2018/11/1.
 */
public class CompletableFutureParallel {

    private static final int CORE_POOL_SIZE = 4;

    private static final int MAX_POOL_SIZE = 12;

    private static final long KEEP_ALIVE_TIME = 5L;

    private final static int QUEUE_SIZE = 1600;

    protected final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE));


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        OrderInfo orderInfo = new OrderInfo();
        //CompletableFuture 的List
        List<CompletableFuture> futures = new ArrayList<>();

        futures.add(CompletableFuture.runAsync(() -> {
            System.out.println("当前任务Customer,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setCustomerInfo(new CustomerInfo());
        }, THREAD_POOL));

        futures.add(CompletableFuture.runAsync(() -> {
            System.out.println("当前任务Discount,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setDiscountInfo(new DiscountInfo());
        }, THREAD_POOL));

        futures.add(CompletableFuture.runAsync(() -> {
            System.out.println("当前任务Food,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setFoodListInfo(new FoodListInfo());
        }, THREAD_POOL));

        futures.add(CompletableFuture.runAsync(() -> {
            System.out.println("当前任务Other,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setOtherInfo(new OtherInfo());
        }, THREAD_POOL));

        CompletableFuture allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allDoneFuture.get(10, TimeUnit.SECONDS);
        System.out.println(orderInfo);
    }


    static class OrderInfo {
        private OtherInfo otherInfo;
        private TenantInfo tenantInfo;
        private FoodListInfo foodListInfo;
        private DiscountInfo discountInfo;
        private CustomerInfo customerInfo;

        public OtherInfo getOtherInfo() {
            return otherInfo;
        }

        public OrderInfo setOtherInfo(OtherInfo otherInfo) {
            this.otherInfo = otherInfo;
            return this;
        }

        public TenantInfo getTenantInfo() {
            return tenantInfo;
        }

        public OrderInfo setTenantInfo(TenantInfo tenantInfo) {
            this.tenantInfo = tenantInfo;
            return this;
        }

        public FoodListInfo getFoodListInfo() {
            return foodListInfo;
        }

        public OrderInfo setFoodListInfo(FoodListInfo foodListInfo) {
            this.foodListInfo = foodListInfo;
            return this;
        }

        public DiscountInfo getDiscountInfo() {
            return discountInfo;
        }

        public OrderInfo setDiscountInfo(DiscountInfo discountInfo) {
            this.discountInfo = discountInfo;
            return this;
        }

        public CustomerInfo getCustomerInfo() {
            return customerInfo;
        }

        public OrderInfo setCustomerInfo(CustomerInfo customerInfo) {
            this.customerInfo = customerInfo;
            return this;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("OrderInfo{");
            sb.append("otherInfo=").append(otherInfo);
            sb.append(", tenantInfo=").append(tenantInfo);
            sb.append(", foodListInfo=").append(foodListInfo);
            sb.append(", discountInfo=").append(discountInfo);
            sb.append(", customerInfo=").append(customerInfo);
            sb.append('}');
            return sb.toString();
        }
    }

    static class OtherInfo {
    }

    static class TenantInfo {
    }

    static class FoodListInfo {
    }

    static class DiscountInfo {
    }

    static class CustomerInfo {
    }
}
