package com.tuandai.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by liusongrui on 2018/11/1.
 */
public class OrderTask extends RecursiveTask<OrderInfo> {


    @Override
    protected OrderInfo compute() {

        System.out.println("执行" + this.getClass().getSimpleName() + "线程名字为:" + Thread.currentThread().getName());
        // 定义其他五种并行TasK
        CustomerTask customerTask = new CustomerTask();
        TenantTask tenantTask = new TenantTask();
        DiscountTask discountTask = new DiscountTask();
        FoodTask foodTask = new FoodTask();
        OtherTask otherTask = new OtherTask();
        invokeAll(customerTask, tenantTask, discountTask, foodTask, otherTask);
        OrderInfo orderInfo = new OrderInfo(otherTask.join(), tenantTask.join(), foodTask.join(), discountTask.join(), customerTask.join());
        return orderInfo;

    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
        System.out.println(forkJoinPool.invoke(new OrderTask()));
    }


}


class CustomerTask extends RecursiveTask<CustomerInfo> {
    @Override
    protected CustomerInfo compute() {
        System.out.println("执行" + this.getClass().getSimpleName() + "线程名字为:" + Thread.currentThread().getName());
        return new CustomerInfo();
    }
}


class TenantTask extends RecursiveTask<TenantInfo> {
    @Override
    protected TenantInfo compute() {
        System.out.println("执行" + this.getClass().getSimpleName() + "线程名字为:" + Thread.currentThread().getName());
        return new TenantInfo();
    }
}


class DiscountTask extends RecursiveTask<DiscountInfo> {
    @Override
    protected DiscountInfo compute() {
        System.out.println("执行" + this.getClass().getSimpleName() + "线程名字为:" + Thread.currentThread().getName());
        return new DiscountInfo();
    }
}

class FoodTask extends RecursiveTask<FoodListInfo> {
    @Override
    protected FoodListInfo compute() {
        System.out.println("执行" + this.getClass().getSimpleName() + "线程名字为:" + Thread.currentThread().getName());
        return new FoodListInfo();
    }
}


class OtherTask extends RecursiveTask<OtherInfo> {
    @Override
    protected OtherInfo compute() {
        System.out.println("执行" + this.getClass().getSimpleName() + "线程名字为:" + Thread.currentThread().getName());
        return new OtherInfo();
    }
}


