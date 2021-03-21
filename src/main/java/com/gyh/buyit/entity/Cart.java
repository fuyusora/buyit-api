package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class Cart {
    private int cartId;
    private int goodId;
    private int skuId;
    private int userId;
    private int quantity;
}
