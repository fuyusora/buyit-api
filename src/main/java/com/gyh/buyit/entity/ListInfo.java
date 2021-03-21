package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class ListInfo {
    private int start;
    private int pageSize;
    private String prop;
    private String order;
}
