package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class Admin {
    private int adminId;
    private String adminName;
    private String password;
    private String authority;
    private String status;
    private String token;
}
