package com.ecommerce.model;

public class Order {

    private String id;
    private double amount;
    private String orderType;

    public Order(double amount, String orderType) {
        this.amount = amount;
        this.orderType = orderType;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
