package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class Banner {
    private int bannerId;
    private String bannerName;
    private String bannerPath;
    private String link;
    private int priority;
}
