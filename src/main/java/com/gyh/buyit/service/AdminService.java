package com.gyh.buyit.service;

import com.gyh.buyit.entity.Admin;
import com.gyh.buyit.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Admin findAdminByAdminId(int adminId){
        return adminMapper.findAdminByAdminId(adminId);
    }
}
