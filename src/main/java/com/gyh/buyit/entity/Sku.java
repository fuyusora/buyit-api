package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class Sku {
    private int skuId;
    private int goodId;
    private String color;
    private String version;
    private String price;
    private int stock;
    private String skuImg;
}
