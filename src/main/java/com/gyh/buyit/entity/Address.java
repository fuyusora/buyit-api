package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class Address {
    private int addressId;
    private int userId;
    private String areaName;
    private String detailAddress;
    private String receiver;
    private String phone;
}
