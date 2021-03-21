package com.gyh.buyit.entity;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String phone;
    private String userName;
    private String password;
    private String avatar;
    private String sex;
    private String birthday;
    private String status;
    private String token;
}
