package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class Order {
    private int orderId;
    private int goodId;
    private int skuId;
    private int userId;
    private String goodName;
    private String color;
    private String version;
    private int quantity;
    private String price;
    private String orderTime;
    private String status;
    private String addressName;
    private String receiver;
    private String phone;
}
