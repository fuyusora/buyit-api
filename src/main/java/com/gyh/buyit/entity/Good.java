package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class Good {
    private int goodId;
    private String goodName;
    private String slogan;
    private String categoryKey;
    private String detailImg;
    private String defaultSkuId;
}
