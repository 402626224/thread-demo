package com.tuandai.thread.forkjoin;

/**
 * Created by liusongrui on 2018/11/1.
 */
public class OrderInfo {

    private OtherInfo otherInfo;
    private TenantInfo tenantInfo;
    private FoodListInfo foodListInfo;
    private DiscountInfo discountInfo;
    private CustomerInfo customerInfo;

    public OrderInfo() {
    }

    public OrderInfo(OtherInfo otherInfo, TenantInfo tenantInfo, FoodListInfo foodListInfo, DiscountInfo discountInfo, CustomerInfo customerInfo) {
        this.otherInfo = otherInfo;
        this.tenantInfo = tenantInfo;
        this.foodListInfo = foodListInfo;
        this.discountInfo = discountInfo;
        this.customerInfo = customerInfo;
    }

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

class OtherInfo {
}

class TenantInfo {
}

class FoodListInfo {
}

class DiscountInfo {
}

class CustomerInfo {
}